package com.java19.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.util.HashMap;

@Service
public class DynamoDBService {
    private DynamoDbClient dynamoDbClient(){
       return DynamoDbClient.builder().region(Region.US_EAST_1).build();
    }

    public void putDynamoDBItems(String customerId,String customerFname,String customerState,String customerZipcode,
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

        }
    }
}
