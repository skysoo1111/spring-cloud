# 프로젝트 기동 옵션
> clean bootRun -Pprofile=dev

# Feign
1. Feign은 Netflix에서 개발된 Http Client Binder 이다.
2. 웹 서비스 클라이언트를 보다 쉽게 작성할 수 있다.
3. interface를 작성하고 annotation을 선언하기만 하면 된다.

postman.http에서 feign 테스트 api가 있으니 실행해보면 된다.

## 1. customapi
module1 프로젝트의 Provider Controller와 매핑되는 커스텀 API

## 2. openapi
Naver Open API로 의 호출
1. legacy 방식의 호출과 feign 방식 모두 구현되어 있고 @FeignClient 사용으로 많은 코드를 줄일수 있다.

=> MSA 아키텍처에서 각 서비스 모듈별로의 API 호출이 많을 수 밖에 없는데 코드량을 줄여주고 서비스 로직에 집중할 수 있도록 도와준다.  
