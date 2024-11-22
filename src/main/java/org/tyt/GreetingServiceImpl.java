package org.tyt;

import io.grpc.stub.StreamObserver;
import org.tyt.grpc.GreetingServiceGrpc;
import org.tyt.grpc.GreetingServiceOuterClass;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        //отправляем поток данных
        /*for(int i = 0; i < 10000; i++){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                    .newBuilder()
                    .setGreeting("Hello from server, " + request.getName())
                    .build();
            responseObserver.onNext(response);
        }*/

        //отправляем один ответ
        System.out.println(request);
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                .newBuilder()
                .setGreeting("Hello from server, " + request.getName())
                .build();
        responseObserver.onNext(response);

        responseObserver.onCompleted(); //означает что мы больше не будем пересылать данные
    }
}
