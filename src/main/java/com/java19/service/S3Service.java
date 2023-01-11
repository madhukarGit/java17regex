package com.java19.service;

import com.java19.domain.Customer;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S3Service {

    private static void readJsonS3() throws IOException {
        S3Client client = S3Client.builder().region(Region.US_EAST_1).build();

        DynamoDbClient ddb = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .build();

        ListObjectsRequest listObjectsRequest = ListObjectsRequest
                .builder()
                .bucket("retail-db-json-redshift")
                .build();

        ListObjectsResponse listObjectsResponse = client.listObjects(listObjectsRequest);
        List<S3Object> objects = listObjectsResponse.contents();
        //objects.forEach(obj-> System.out.println(obj.key()));
        /*categories/part-r-00000-ce1d8208-178d-48d3-bfb2-1a97d9c05094
        create_db_tables_pg.sql
        customers/part-r-00000-70554560-527b-44f6-9e80-4e2031af5994
        departments/part-r-00000-3db7cfae-3ad2-4fc7-88ff-afe0ec709f49
        order_items/part-r-00000-6b83977e-3f20-404b-9b5f-29376ab1419e
        orders/part-r-00000-990f5773-9005-49ba-b670-631286032674
        products/part-r-00000-158b7037-4a23-47e6-8cb3-8cbf878beff7
         */
        String regex = "(?<fileName>cu\\w+[/-]\\w+-r-[A-Za-z0-9\\s-]*)\\b.*";
        Pattern pattern = Pattern.compile(regex,Pattern.DOTALL | Pattern.COMMENTS);
        AtomicReference<String> fileKey = new AtomicReference<>("");
        objects.forEach(obj->{
           Matcher matcher = pattern.matcher(obj.key());
           if(matcher.matches()){
               fileKey.set(matcher.group("fileName"));
           }
        });
        System.out.println(fileKey.get());

        GetObjectRequest getObjectRequest = GetObjectRequest.builder().
                            bucket("retail-db-json-redshift").
                        key(fileKey.get()).
                    build();

        ResponseInputStream<GetObjectResponse> responseInputStream =client.getObject(getObjectRequest);
        InputStream stream = new ByteArrayInputStream(responseInputStream.readAllBytes());
        BufferedReader bufferedReader
                =new BufferedReader(new InputStreamReader(stream,"UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String inputStr = "";
        List jsonArray = new ArrayList();
        while((inputStr = bufferedReader.readLine()) != null){
            jsonArray.add(new JSONObject(inputStr));

        }
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        for(int i=0;i<jsonArray.size();i++){
            String regexCust = """
                    [{][\".]customer_id\"[:](?<customerId>\\d{1,})\\b.*
                    ,\"customer_fname\":\"(?<customerFname>\\w+)\\b.*
                    ,\"customer_lname\":\"(?<customerLname>\\w+)\\b.*  
                    ,\"customer_email\":\"(?<customerEmail>\\w+)\\b.*
                    ,\"customer_password\":\"(?<customerPassword>\\w+)\\b.*
                    ,\"customer_street\":\"(?<customerStreet>\\w+)\\b\\n
                    """;

            /*
            * {"customer_id":2,"customer_fname":"Mary","customer_lname":"Barrett","customer_email":"XXXXXXXXX",
            * "customer_password":"XXXXXXXXX","customer_street":"9526 Noble Embers Ridge","customer_city":"Littleton",
            * "customer_state":"CO","customer_zipcode":"80126"}
            * */


            /*
            {"customer_password":"XXXXXXXXX","customer_state":"TX","customer_zipcode":"78521",
            "customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard",
            "customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
            */
            String regexBig = """
                    [{][\"]customer_id[\"][:](?<customerId>\\d{1,})[,]
                    [\"]customer_fname[\"][:][\"](?<customerFname>\\w+)[\"][,]
                    [\"]customer_lname[\"][:][\"](?<customerLname>\\w+)[\"][,]
                    [\"]customer_email[\"][:][\"](?<customerEmail>\\w+)[\"][,]
                    [\"]customer_password[\"][:][\"](?<customerPassword>\\w+)[\"][,] 
                    [\"]customer_street[\"][:][\"](?<customerStreet>[0-9\\s\\w]*)[\"][,]
                    [\"]customer_city[\"][:][\"](?<customerCity>\\w+)[\"][,]
                    [\"]customer_state[\"][:][\"](?<customerState>\\w+)[\"][,]
                    [\"]customer_zipcode[\"][:][\"](?<customerZipcode>\\d+)[\"][}]\\n                          
                    """;

            String jsonRegex = """
                [{][\"]customer_password[\"][:][\"](?<customerPassword>\\w+)[\"][,]
                [\"]customer_state[\"][:][\"](?<customerState>\\w+)[\"][,]
                [\"]customer_zipcode[\"][:][\"](?<customerZipcode>\\d+)[\"][,]
                [\"]customer_email[\"][:][\"](?<customerEmail>\\w+)[\"][,]
                [\"]customer_lname[\"][:][\"](?<customerLname>\\w+)[\"][,]
                [\"]customer_fname[\"][:][\"](?<customerFname>\\w+)[\"][,]
                [\"]customer_id[\"][:](?<customerId>\\d{1,})[,]
                [\"]customer_street[\"][:][\"](?<customerStreet>[0-9\\s\\w]*)[\"][,]
                [\"]customer_city[\"][:][\"](?<customerCity>\\w+)[\"][}]
                """;
            Pattern pattern1 = Pattern.compile(jsonRegex,Pattern.DOTALL | Pattern.COMMENTS);
            String val = jsonArray.get(i).toString();
            System.out.println("val is "+val);
            Matcher matcher = pattern1.matcher(val);

            /*
            * Dynamo DB insert into table
            * */
            while(matcher.find()) {
                System.out.println(matcher.group("customerId"));
                System.out.println(matcher.group("customerFname"));
                System.out.println(matcher.group("customerLname"));
                System.out.println(matcher.group("customerEmail"));
                System.out.println(matcher.group("customerStreet"));
                System.out.println(matcher.group("customerCity"));
                System.out.println("..............");
                String customerId = matcher.group("customerId");
                String customerFname = matcher.group("customerFname");
                String customerState = matcher.group("customerState");
                String customerZipcode = matcher.group("customerZipcode");
                String customerEmail = matcher.group("customerEmail");
                String customerLname = matcher.group("customerLname");
                String customerStreet = matcher.group("customerStreet");
                String customerCity = matcher.group("customerCity");
                putDynamoDBItems(customerId,customerFname,customerState,customerZipcode,customerEmail,
                        customerLname,customerStreet,customerCity);
            }
//            if(matcher.matches()){
//                customer.setCustomerId(matcher.group("customerId"));
//                customer.setCustomerFname(matcher.group("customerFname"));
//                customer.setCustomerLname(matcher.group("customerLname"));
//                customer.setCustomerEmail(matcher.group("customerEmail"));
//                customer.setCustomerCity(matcher.group("customerCity"));
//                customer.setCustomerState(matcher.group("customerState"));
//                customerList.add(customer);
//            }else{
//                System.out.println("no matches");
//            }
        }

        customerList.forEach(customer1 -> System.out.println(customer1.getCustomerState()+" "+customer1.getCustomerZipcode()));

    }

    /*
    * {"customer_password":"XXXXXXXXX","customer_state":"TX","customer_zipcode":"78521","customer_email":"XXXXXXXXX",
    * "customer_lname":"Hernandez","customer_fname":"Richard","customer_id":1,"customer_street":"6303 Heather Plaza",
    * "customer_city":"Brownsville"}
    * */

    public static void main(String[] args) throws IOException {
        readJsonS3();
    }

    private static DynamoDbClient dynamoDbClient(){
        return DynamoDbClient.builder().region(Region.US_EAST_1).build();
    }

    public static void putDynamoDBItems(String customerId,String customerFname,String customerState,String customerZipcode,
                                 String customerEmail,String customerLname,String customerStreet,String customerCity){
        HashMap<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("customer_id",AttributeValue.builder().s(customerId).build());
        itemValues.put("customer_fname",AttributeValue.builder().s(customerFname).build());
        itemValues.put("customer_state",AttributeValue.builder().s(customerState).build());
        itemValues.put("customer_zipcode",AttributeValue.builder().s(customerZipcode).build());
        itemValues.put("customer_email",AttributeValue.builder().s(customerEmail).build());
        itemValues.put("customer_lname",AttributeValue.builder().s(customerLname).build());
        itemValues.put("customer_street",AttributeValue.builder().s(customerStreet).build());
        itemValues.put("customer_city",AttributeValue.builder().s(customerCity).build());

        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName("customer")
                .item(itemValues)
                .build();

        try{
            PutItemResponse putItemResponse = dynamoDbClient().putItem(putItemRequest);
            System.out.println("customer "+putItemResponse.responseMetadata().requestId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
