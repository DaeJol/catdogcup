# catdogcup (개냥컵)
- 고양이와 강아지를 기르고 있는 당신!
- 고양이와 강아지를 좋아하는 당신!
- 고양이와 강아지를 기르고 싶지만 기르지 못하는 당신!
- 더 많은 고양이와 강아지를 보고 싶은 당신!

많은 귀엽고 깜찍한 고양이와 강아지를 보고 자신이 가장 좋아하는 아이들을 픽할 수 있는 고양이 &amp; 강아지 월드컵입니다!

catdogcup에서 많은 친구들을 만나보세요.

## 기본 화면

<img src="https://github.com/DaeJol/catdogcup/assets/26290540/393bd5fd-9f58-4294-80e4-5c81fafd49b6" width="240" height="500"/>

<img src="https://github.com/DaeJol/catdogcup/assets/26290540/39d1a71c-8927-4a61-a4b5-abe23c6b060f" width="240" height="500"/>

<img src="https://github.com/DaeJol/catdogcup/assets/26290540/4a54f126-d089-415b-83e9-397d57a9cb6c" width="240" height="500"/>





## [WorkLog]

<details>
<summary>2024.06.07</summary>


## 1. 데이터 클래스의 통합 이슈
아래의 경우 통합 관련
CatBreedsDto + DogBreedsDto -> BreedsDto
CatImageDto + DogImageDto -> ImageDto

- Dto 자체를 통합해서 각각의 API를 상속받아서 사용하려고 하니까, 오히려 구조가 깔끔하지 않고 상속 때문에 개발이 복잡해지는 문제가 발생
- 과연 굳이 클래스를 하나로 통합하고 상속받아서 사용하는 것이 나을지, 각 API는 결국 다른 구조의 API의 가능성이 있기에 그대로 따로 사용하는 것이 나을지 논의 피료

## 2. 모듈의 세부적인 분리
기존 data 레이어는 임시적으로 catApi만 부르고 있다.
그런데 모듈을 분리하는 이유는 결국 api가 변경되거나 추가될 때 좀 더 효율적으로 해당 base 도메인의 api를 관리하기 위해
분리하는 것이다. 따라서 각 api 데이터 모듈의 이름도 명확할 필요가 있다고 생각했다.
data -> catData / dogData

</details>
