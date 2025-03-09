package com.yohanna.songlist.message;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class SqsProducer {
    private final String QUEUE_NAME = "https://sqs.us-east-1.amazonaws.com/123456789012/MyQueue";
    AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
    String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

    public void sendMessage(String message) {
        sqs.sendMessage(queueUrl, message);
    }
}
