# 프로젝트 기동 옵션
> clean bootRun -Pprofile=dev

# Feign
1. Feign은 Netflix에서 개발된 Http Client Binder 이다.
2. 웹 서비스 클라이언트를 보다 쉽게 작성할 수 있다.
3. interface를 작성하고 annotation을 선언하기만 하면 된다.

postman.http에서 feign 테스트 api가 있으니 실행해보면 된다.

# Feign 구현
1. @EnableFeignClients 는 root package에 선언하고 지정된 package 를 돌면서 @FeignClient 를 찾아서 구현체를 만든다.
2. @FeignClient 는 interface 이며, 수동으로 구현체를 만들 수도 있다.

## Feign 설정
1. Header 설정
- 메서드 별 설정이 필요한 경우 : annotation 이용
~~~java
@GetMapping(value = "/status/", headers = "key2=value2")
void status2(@PathVariable("status") int status);

@GetMapping(value = "/status/")
void status3(@RequestHeader("key3") String headers, @PathVariable("status") int status);

// 이 호출은 Header 에 값이 설정되지 않습니다.
// @GetMapping 은 SpringMVcContract 를 사용해야하고, @Headers 는 feign Contract 를 사용해야 합니다.
@org.springframework.web.bind.annotation.GetMapping(value = "/status/")
@feign.Headers("key3: value3")
void status4(@PathVariable("status") int status);
~~~

- Feign Client 별 설정이 필요한 경우 : Configuration 이용 (interceptor)
~~~java
public class HeaderConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("header", "header1", "header2");
    }
}
~~~

2. Contract
- feign.Contract.Default
feign default Contract 사용시 @RequestLine 을 사용해야 한다.
~~~java @RequestLine("GET /fail/") ~~~
- SpringMvcContract
Feign Client에서 @GetMapping, @PostMapping, @RequestMapping 을 사용할 수 있다.
 

## 1. customapi
module1 프로젝트의 Provider Controller와 매핑되는 커스텀 API

## 2. openapi
Naver Open API로 의 호출
1. legacy 방식의 호출과 feign 방식 모두 구현되어 있고 @FeignClient 사용으로 많은 코드를 줄일수 있다.

=> MSA 아키텍처에서 각 서비스 모듈별로의 API 호출이 많을 수 밖에 없는데 코드량을 줄여주고 서비스 로직에 집중할 수 있도록 도와준다. 

[참고 사이트1](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html)
[참고 사이트2](https://techblog.woowahan.com/2630/)
