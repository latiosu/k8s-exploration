package com.notification.mailer;

import org.springframework.grpc.server.service.GrpcService;

import com.notifications.proto.NotifyResponse;
import com.notifications.proto.NotifyRequest;
import com.notifications.proto.NotificationGrpc;

import io.grpc.stub.StreamObserver;

@GrpcService
public class NotificationService extends NotificationGrpc.NotificationImplBase{

    @Override
    public void notify(NotifyRequest request, StreamObserver <NotifyResponse> responseObserver){
        String email = request.getEmail();
        String message = "Server is returning a response";

        NotifyResponse response = NotifyResponse.newBuilder().setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
}
