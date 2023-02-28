package io.grpc.stock;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StockServiceGrpc {

  private StockServiceGrpc() {}

  public static final String SERVICE_NAME = "stock.StockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.stock.StockRequest,
      io.grpc.stock.StockResponse> getQueryStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryStock",
      requestType = io.grpc.stock.StockRequest.class,
      responseType = io.grpc.stock.StockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.stock.StockRequest,
      io.grpc.stock.StockResponse> getQueryStockMethod() {
    io.grpc.MethodDescriptor<io.grpc.stock.StockRequest, io.grpc.stock.StockResponse> getQueryStockMethod;
    if ((getQueryStockMethod = StockServiceGrpc.getQueryStockMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getQueryStockMethod = StockServiceGrpc.getQueryStockMethod) == null) {
          StockServiceGrpc.getQueryStockMethod = getQueryStockMethod =
              io.grpc.MethodDescriptor.<io.grpc.stock.StockRequest, io.grpc.stock.StockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.stock.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.stock.StockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("QueryStock"))
              .build();
        }
      }
    }
    return getQueryStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.stock.TradeRequest,
      io.grpc.stock.TradeResponse> getTradeStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TradeStock",
      requestType = io.grpc.stock.TradeRequest.class,
      responseType = io.grpc.stock.TradeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.stock.TradeRequest,
      io.grpc.stock.TradeResponse> getTradeStockMethod() {
    io.grpc.MethodDescriptor<io.grpc.stock.TradeRequest, io.grpc.stock.TradeResponse> getTradeStockMethod;
    if ((getTradeStockMethod = StockServiceGrpc.getTradeStockMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getTradeStockMethod = StockServiceGrpc.getTradeStockMethod) == null) {
          StockServiceGrpc.getTradeStockMethod = getTradeStockMethod =
              io.grpc.MethodDescriptor.<io.grpc.stock.TradeRequest, io.grpc.stock.TradeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TradeStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.stock.TradeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.stock.TradeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("TradeStock"))
              .build();
        }
      }
    }
    return getTradeStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.stock.UpdatePriceRequest,
      io.grpc.stock.UpdatePriceResponse> getUpdatePriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrice",
      requestType = io.grpc.stock.UpdatePriceRequest.class,
      responseType = io.grpc.stock.UpdatePriceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.stock.UpdatePriceRequest,
      io.grpc.stock.UpdatePriceResponse> getUpdatePriceMethod() {
    io.grpc.MethodDescriptor<io.grpc.stock.UpdatePriceRequest, io.grpc.stock.UpdatePriceResponse> getUpdatePriceMethod;
    if ((getUpdatePriceMethod = StockServiceGrpc.getUpdatePriceMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getUpdatePriceMethod = StockServiceGrpc.getUpdatePriceMethod) == null) {
          StockServiceGrpc.getUpdatePriceMethod = getUpdatePriceMethod =
              io.grpc.MethodDescriptor.<io.grpc.stock.UpdatePriceRequest, io.grpc.stock.UpdatePriceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.stock.UpdatePriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.stock.UpdatePriceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("UpdatePrice"))
              .build();
        }
      }
    }
    return getUpdatePriceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StockServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StockServiceStub>() {
        @java.lang.Override
        public StockServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StockServiceStub(channel, callOptions);
        }
      };
    return StockServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StockServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StockServiceBlockingStub>() {
        @java.lang.Override
        public StockServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StockServiceBlockingStub(channel, callOptions);
        }
      };
    return StockServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StockServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StockServiceFutureStub>() {
        @java.lang.Override
        public StockServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StockServiceFutureStub(channel, callOptions);
        }
      };
    return StockServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class StockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void queryStock(io.grpc.stock.StockRequest request,
        io.grpc.stub.StreamObserver<io.grpc.stock.StockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryStockMethod(), responseObserver);
    }

    /**
     */
    public void tradeStock(io.grpc.stock.TradeRequest request,
        io.grpc.stub.StreamObserver<io.grpc.stock.TradeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTradeStockMethod(), responseObserver);
    }

    /**
     */
    public void updatePrice(io.grpc.stock.UpdatePriceRequest request,
        io.grpc.stub.StreamObserver<io.grpc.stock.UpdatePriceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePriceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQueryStockMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.stock.StockRequest,
                io.grpc.stock.StockResponse>(
                  this, METHODID_QUERY_STOCK)))
          .addMethod(
            getTradeStockMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.stock.TradeRequest,
                io.grpc.stock.TradeResponse>(
                  this, METHODID_TRADE_STOCK)))
          .addMethod(
            getUpdatePriceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.stock.UpdatePriceRequest,
                io.grpc.stock.UpdatePriceResponse>(
                  this, METHODID_UPDATE_PRICE)))
          .build();
    }
  }

  /**
   */
  public static final class StockServiceStub extends io.grpc.stub.AbstractAsyncStub<StockServiceStub> {
    private StockServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StockServiceStub(channel, callOptions);
    }

    /**
     */
    public void queryStock(io.grpc.stock.StockRequest request,
        io.grpc.stub.StreamObserver<io.grpc.stock.StockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void tradeStock(io.grpc.stock.TradeRequest request,
        io.grpc.stub.StreamObserver<io.grpc.stock.TradeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTradeStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePrice(io.grpc.stock.UpdatePriceRequest request,
        io.grpc.stub.StreamObserver<io.grpc.stock.UpdatePriceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePriceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StockServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StockServiceBlockingStub> {
    private StockServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stock.StockResponse queryStock(io.grpc.stock.StockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.stock.TradeResponse tradeStock(io.grpc.stock.TradeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTradeStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.stock.UpdatePriceResponse updatePrice(io.grpc.stock.UpdatePriceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePriceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StockServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StockServiceFutureStub> {
    private StockServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.stock.StockResponse> queryStock(
        io.grpc.stock.StockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.stock.TradeResponse> tradeStock(
        io.grpc.stock.TradeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTradeStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.stock.UpdatePriceResponse> updatePrice(
        io.grpc.stock.UpdatePriceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePriceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_STOCK = 0;
  private static final int METHODID_TRADE_STOCK = 1;
  private static final int METHODID_UPDATE_PRICE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_STOCK:
          serviceImpl.queryStock((io.grpc.stock.StockRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.stock.StockResponse>) responseObserver);
          break;
        case METHODID_TRADE_STOCK:
          serviceImpl.tradeStock((io.grpc.stock.TradeRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.stock.TradeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PRICE:
          serviceImpl.updatePrice((io.grpc.stock.UpdatePriceRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.stock.UpdatePriceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.stock.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockService");
    }
  }

  private static final class StockServiceFileDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier {
    StockServiceFileDescriptorSupplier() {}
  }

  private static final class StockServiceMethodDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockServiceFileDescriptorSupplier())
              .addMethod(getQueryStockMethod())
              .addMethod(getTradeStockMethod())
              .addMethod(getUpdatePriceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
