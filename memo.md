> 요청 파라미터 VS HTTP 메시지 바디
- 요청파라미터 : @RequestParam, @ModelAttribute
- HTTP 메시지 바디 : @RequestBody
> HTTP 응답 - 정적 리소스, 뷰 템플릿, HTTP 메시지 사용
- 정적 리소스 : 웹 브라우저에 정적인 HTML, css, js 를 제공할 때
- 뷰 템플릿 : 웹 브라우저에 동적인 HTML을 사용할 때
- Http 메시지 : HTTP API 를 제공하는 경우에 데이터를 JSON 과 같은 형식으로 실어 보낼 때


스트링 부트는 '/static', '/public', '/resources', '/META-INF/resources' 디렉토리에서 정적 리소스를 제공함
