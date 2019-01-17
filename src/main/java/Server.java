import handler.ReactiveHandler;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.ipc.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {

    private ReactiveHandler requestHandler;

    public Server(){
        requestHandler = new ReactiveHandler();
    }

    /**
     * build the router
     * @return the router
     */
    public RouterFunction<ServerResponse> buildResultRouter() {
        return RouterFunctions
                .route(RequestPredicates.GET("/s5/get/{id}")
                        .and(RequestPredicates
                                .accept(MediaType.APPLICATION_JSON_UTF8)), requestHandler::extraResult)
                .andRoute(RequestPredicates.GET("/s5/list")
                        .and(RequestPredicates
                                .accept(MediaType.APPLICATION_JSON_UTF8)), requestHandler::listResult)
                .andRoute(RequestPredicates.POST("/s5/put/")
                        .and(RequestPredicates
                                .accept(MediaType.APPLICATION_JSON_UTF8)), requestHandler::createView);
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.buildResultRouter();
        server.tomcatServer();
//        server.nettyServer();
    }

    public void tomcatServer() {

        RouterFunction<?> route = buildResultRouter();
        HttpHandler httpHandler = toHttpHandler(route);

        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setHostname("localhost");
        tomcatServer.setPort(8600);
        Context rootContext = tomcatServer.addContext("", System.getProperty("java.io.tmpdir"));
        ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
        Tomcat.addServlet(rootContext, "httpHandlerServlet", servlet);
        rootContext.addServletMapping("/", "httpHandlerServlet");
        try {
            tomcatServer.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        //block
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void nettyServer() {

        RouterFunction<ServerResponse> router = buildResultRouter();

        HttpHandler httpHandler = toHttpHandler(router);

        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);

        //create the netty server
        HttpServer httpServer = HttpServer.create("localhost", 8600);

        //start the netty http server
        httpServer.newHandler(httpHandlerAdapter).block();

        //block
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
