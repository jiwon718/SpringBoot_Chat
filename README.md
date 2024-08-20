해당 프로젝트는 맛잇다라는 번역 서비스를 지원하는 온라인 쿠킹 클래스 웹사이트를 제작하는 프로젝트를 진행하면서 채팅 서버를 구현하기 위해 공부한 내용을 정리한 것입니다.  
맛잇다의 채팅 서버에서 제공하는 번역 채팅 기능으로 사용자가 메시지를 전송하면 같은 채팅방에 있는 다른 사용자가 설정한 언어로 번역되어서 전송되는 것이지만, 해당 프로젝트에서는 번역하는 과정을 제외한 채팅의 과정만 포함합니다. ChatGPT API를 활용하여 번역하는 과정을 포함한 전 과정을 살펴보시려면 다음 주소를 참고해주시기 바랍니다. 😆

맛잇다: https://github.com/Tasty-Ties

<br/>

# 구현한 기능

:white_check_mark: 간단한 다대다 채팅하기  
:white_large_square: 방을 구분하여 다대다 채팅하기  
:white_large_square: MongoDB에 채팅 메시지 저장하기  
:white_large_square: RabbitMQ을 사용하여 메인 서버와 통신하기  
:white_large_square: Spring Security + JWT 적용하여 사용자 인증하기
