package nakup.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RouteLocator userRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user-service", r -> r.path("/api/user/**")
						.uri("lb://user-service"))
				.build();
	}

	@Bean
	public RouteLocator productRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("product-service", r -> r.path("/api/product/**")
						.uri("lb://product-service"))
				.build();
	}

	@Bean
	public RouteLocator inventoryRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("inventory-service", r -> r.path("/api/inventory/**")
						.uri("lb://inventory-service"))
				.build();
	}

	@Bean
	public RouteLocator paymentRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("payment-service", r -> r.path("/api/payment/**")
						.uri("lb://payment-service"))
				.build();
	}

	@Bean
	public RouteLocator orderRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("order-service", r -> r.path("/api/order/**")
						.uri("lb://order-service"))
				.build();
	}

	@Bean
	public RouteLocator cartRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("cart-service", r -> r.path("/api/cart/**")
						.uri("lb://cart-service"))
				.build();
	}
}
