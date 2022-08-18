# Spring Jpa Backend Server prac
 
1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body) → 수정의 경우 RequestDto의 형식에 맞춰 body로 수정 양식을 전부 받아왔고, 삭제의 경우는 param을 사용하였습니다.
2. 어떤 상황에 어떤 방식의 request를 써야하나요? → 안에 인수가 많이 있고, 키-값 구조가 없는 경우 body를 사용하였고, resource를 식별해야 하는 경우 param을 사용하였습니다. query의 경우 정렬이나 필터를 해야하는 상황에서 사용하였습니다.
3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요? → 게시글 CRUD를 만들때 REST의 메소드를 적극적으로 활용하였고, URL을 표현할 때 소문자를 사용하고, 동사 표현이 안들어가게 신경 썼습니다. 적절한 에러 코드를 출력해주지 못한 점이 아쉽습니다.
4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service) → Controller의 경우 요청을 처리 한 후 지정된 뷰(View)에 모델 객체를 넘겨주는 역할만을 할 수 있도록 URL와 Service를 연결해주었고, 업데이트의 기능이나 비밀번호 대조와 같은 기능의 함수들은 Service에 넣어주었습니다. 남은 기능들은 utils파일을 만들어 넣어주었고, models에 dto와 여러 db 테이블클래스 repository를 넣어서 관리해주었습니다.
5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요 → `@RequiredArgsConstructor` `@Entity` `@Service` `@Container` `@Controller` 등을 사용하였습니다.
6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요! → 제가 작성한 API 명세서에서는 변수 명칭과 에러 코드, 데이터 포멧에 대한 사항을 적어주는 것이 부족했었던 것 같습니다.
