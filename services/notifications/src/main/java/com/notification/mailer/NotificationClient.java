package com.notification.mailer;

import org.springframework.stereotype.Service;

import com.notifications.proto.NotificationGrpc;
import com.notifications.proto.NotifyRequest;
import com.notifications.proto.NotifyResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class NotificationClient {
    private final NotificationGrpc.NotificationBlockingStub blockingStub;

  public NotificationClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        this.blockingStub = NotificationGrpc.newBlockingStub(channel);
    }
    public String Notify(String email) {
        NotifyRequest request = NotifyRequest.newBuilder().setEmail(email).build();
        NotifyResponse response = blockingStub.notify(request);
        return response.getMessage();  
    }
}
