# kb 헬스케어 사전 과제 테스트

---

## 요구사항
- 데이터베이스 테이블 설계
- 데이터 저장 조회 샘플 코드 작성

---


## 사용 기술 스텍
- Java 17
- Spring boot 3.4.2
- Spring Data JPA
- Mysql
- Redis

---
## 제품 산출물
1. 데이터베이스 설계 ERD
<img width="948" alt="Image" src="https://github.com/user-attachments/assets/2a306536-3e32-4e55-841c-b58d90ad039d" />


# source 

소스에 대한 정보를 저장합니다. 각 소스는 id로 고유하게 식별되며, 다른 속성으로 mode, name, product_name, type, vendor 등이 있습니다.
# activity_record 

활동에 대한 정보를 저장하는 테이블입니다. 각 활동은 고유한 id로 식별되며, 관련된 record_key를 고유 제약조건으로 설정하여 중복을 방지합니다. 또한, source_id는 source 테이블의 id를 참조하는 외래 키로 설정되어 있습니다.
# activity_entry 

활동의 세부 항목들을 저장하는 테이블로, 각 활동 항목은 activity_record 테이블의 id와 연결됩니다. 각 엔트리는 칼로리, 거리, 걸음 수 등을 저장하며, 활동 시작과 종료 시간을 기록합니다.
---




2. 데이터 조회 결과 제출 (Daily/Monthly 레코드키 기준)

# Daily (recordkey = 3b87c9a4-f983-4168-8f27-85436447bb57)
```json
[
  {
    "Daily": "2024-11-15",
    "Steps": 9589,
    "calories": 345,
    "distance": 7.24323016,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-16",
    "Steps": 5075,
    "calories": 199,
    "distance": 4.2637902895,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-17",
    "Steps": 5179,
    "calories": 183,
    "distance": 3.9831101015,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-18",
    "Steps": 13291,
    "calories": 453,
    "distance": 10.2997199322,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-19",
    "Steps": 8203,
    "calories": 305,
    "distance": 6.3277802163,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-20",
    "Steps": 10055,
    "calories": 341,
    "distance": 7.7173402583,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-21",
    "Steps": 9114,
    "calories": 327,
    "distance": 6.9326903564,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-22",
    "Steps": 8496,
    "calories": 291,
    "distance": 6.540980794,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-23",
    "Steps": 5117,
    "calories": 194,
    "distance": 3.977679997,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-24",
    "Steps": 9089,
    "calories": 329,
    "distance": 6.9697801765,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-25",
    "Steps": 8660,
    "calories": 308,
    "distance": 6.6983400955,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-26",
    "Steps": 7930,
    "calories": 281,
    "distance": 6.081570335,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-27",
    "Steps": 9566,
    "calories": 350,
    "distance": 7.253210088,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-28",
    "Steps": 9769,
    "calories": 347,
    "distance": 7.3867001783,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-29",
    "Steps": 8698,
    "calories": 303,
    "distance": 6.6835101464,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-11-30",
    "Steps": 3114,
    "calories": 107,
    "distance": 2.3598000102,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-01",
    "Steps": 6920,
    "calories": 228,
    "distance": 5.4873501397,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-02",
    "Steps": 8194,
    "calories": 294,
    "distance": 6.2090199387,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-03",
    "Steps": 11103,
    "calories": 383,
    "distance": 8.527580109,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-04",
    "Steps": 8507,
    "calories": 308,
    "distance": 6.4470800127,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-05",
    "Steps": 10329,
    "calories": 375,
    "distance": 7.86841996,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-06",
    "Steps": 12300,
    "calories": 419,
    "distance": 9.4888507254,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-07",
    "Steps": 5063,
    "calories": 220,
    "distance": 4.4469398317,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-08",
    "Steps": 5353,
    "calories": 183,
    "distance": 4.201040036,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-09",
    "Steps": 5740,
    "calories": 191,
    "distance": 4.4660499731,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-10",
    "Steps": 9249,
    "calories": 320,
    "distance": 7.1584999675,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-11",
    "Steps": 10467,
    "calories": 350,
    "distance": 8.13616998644,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-12",
    "Steps": 10929,
    "calories": 372,
    "distance": 8.3910098861,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-13",
    "Steps": 9349,
    "calories": 314,
    "distance": 7.2183498933,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-14",
    "Steps": 4154,
    "calories": 145,
    "distance": 3.1663400222,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-15",
    "Steps": 3412,
    "calories": 116,
    "distance": 2.632960042,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Daily": "2024-12-16",
    "Steps": 9482,
    "calories": 334,
    "distance": 7.2513000017,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  }
]
```
# Monthly (recordkey = 3b87c9a4-f983-4168-8f27-85436447bb57)
```json
[
  {
    "Monthly": "2024-11",
    "Steps": 130945,
    "calories": 4671,
    "distance": 100.7192331351,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  },
  {
    "Monthly": "2024-12",
    "Steps": 130551,
    "calories": 4560,
    "distance": 101.09696052554,
    "recordkey": "3b87c9a4-f983-4168-8f27-85436447bb57"
  }
]
```
# Daily (recordkey = 7836887b-b12a-440f-af0f-851546504b13)
```json
[
  {
    "Daily": "2024-11-15",
    "Steps": 7243,
    "calories": 289,
    "distance": 5.4194896718,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-16",
    "Steps": 10717,
    "calories": 425,
    "distance": 8.0204797034,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-17",
    "Steps": 7390,
    "calories": 288,
    "distance": 5.6080096589999995,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-18",
    "Steps": 7928,
    "calories": 316,
    "distance": 6.03404989,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-19",
    "Steps": 5857,
    "calories": 232,
    "distance": 4.4839393130000005,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-20",
    "Steps": 7762,
    "calories": 310,
    "distance": 5.8415798517,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-21",
    "Steps": 5952,
    "calories": 236,
    "distance": 4.4632696545,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-22",
    "Steps": 9692,
    "calories": 385,
    "distance": 7.3932293041,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-23",
    "Steps": 7619,
    "calories": 303,
    "distance": 5.7530293665,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-24",
    "Steps": 6285,
    "calories": 249,
    "distance": 4.8245898508,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-25",
    "Steps": 6396,
    "calories": 256,
    "distance": 4.9175796168,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-26",
    "Steps": 6815,
    "calories": 280,
    "distance": 5.1118298090000005,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-27",
    "Steps": 11522,
    "calories": 475,
    "distance": 8.7367195778,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-28",
    "Steps": 9423,
    "calories": 385,
    "distance": 7.0484097933,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-29",
    "Steps": 7773,
    "calories": 307,
    "distance": 5.8451199137,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-11-30",
    "Steps": 6409,
    "calories": 258,
    "distance": 4.84076981,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-01",
    "Steps": 6911,
    "calories": 279,
    "distance": 5.277709949,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-02",
    "Steps": 5152,
    "calories": 209,
    "distance": 3.905699725,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-03",
    "Steps": 9253,
    "calories": 366,
    "distance": 6.9904796797,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-04",
    "Steps": 11100,
    "calories": 452,
    "distance": 8.3271197205,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-05",
    "Steps": 13942,
    "calories": 549,
    "distance": 10.4508797352,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-06",
    "Steps": 6069,
    "calories": 244,
    "distance": 4.600989641,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-07",
    "Steps": 6835,
    "calories": 277,
    "distance": 5.1540094107,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-08",
    "Steps": 2943,
    "calories": 115,
    "distance": 2.2430599723,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-09",
    "Steps": 8659,
    "calories": 346,
    "distance": 6.6131799444,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-10",
    "Steps": 6546,
    "calories": 265,
    "distance": 4.9617498627000005,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-11",
    "Steps": 7513,
    "calories": 302,
    "distance": 5.587589773,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-12",
    "Steps": 7093,
    "calories": 285,
    "distance": 5.414469529,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-13",
    "Steps": 8102,
    "calories": 325,
    "distance": 6.1263096022,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-14",
    "Steps": 4797,
    "calories": 191,
    "distance": 3.6570697181,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-15",
    "Steps": 4245,
    "calories": 167,
    "distance": 3.209540023,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Daily": "2024-12-16",
    "Steps": 6432,
    "calories": 257,
    "distance": 4.8564797897,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  }
]
```
# Monthly (recordkey = 7836887b-b12a-440f-af0f-851546504b13)
```json
[
  {
    "Monthly": "2024-11",
    "Steps": 124783,
    "calories": 5002,
    "distance": 94.3420947854,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  },
  {
    "Monthly": "2024-12",
    "Steps": 115592,
    "calories": 4635,
    "distance": 87.3763360755,
    "recordkey": "7836887b-b12a-440f-af0f-851546504b13"
  }
]
```
# Daily (recordkey = 7b012e6e-ba2b-49c7-bc2e-473b7b58e72e)
```json
[
  {
    "Daily": "2024-11-14",
    "Steps": 2231,
    "calories": 0,
    "distance": 1.7876393185402357,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-15",
    "Steps": 6668,
    "calories": 0,
    "distance": 5.343131002743457,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-16",
    "Steps": 5485,
    "calories": 0,
    "distance": 4.397250700970247,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-17",
    "Steps": 4697,
    "calories": 0,
    "distance": 3.7704,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-18",
    "Steps": 10217,
    "calories": 0,
    "distance": 8.18919839170996,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-19",
    "Steps": 7781,
    "calories": 0,
    "distance": 6.237082072137678,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-20",
    "Steps": 6152,
    "calories": 0,
    "distance": 4.9312000000000005,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-21",
    "Steps": 7718,
    "calories": 0,
    "distance": 6.184,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-22",
    "Steps": 9888,
    "calories": 0,
    "distance": 7.920800000000001,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-23",
    "Steps": 8602,
    "calories": 0,
    "distance": 6.898016215129281,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-24",
    "Steps": 4475,
    "calories": 0,
    "distance": 3.587659109984598,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-25",
    "Steps": 7476,
    "calories": 0,
    "distance": 5.992930601855408,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-26",
    "Steps": 8427,
    "calories": 0,
    "distance": 6.753094235814074,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-27",
    "Steps": 8802,
    "calories": 0,
    "distance": 7.0528,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-28",
    "Steps": 7819,
    "calories": 0,
    "distance": 6.2662946648366225,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-29",
    "Steps": 5884,
    "calories": 0,
    "distance": 4.717852652415799,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-11-30",
    "Steps": 5316,
    "calories": 0,
    "distance": 4.260971824348133,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-01",
    "Steps": 7426,
    "calories": 0,
    "distance": 5.954400000000001,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-02",
    "Steps": 5897,
    "calories": 0,
    "distance": 4.72664083056783,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-03",
    "Steps": 9540,
    "calories": 0,
    "distance": 7.649295229249849,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-04",
    "Steps": 8149,
    "calories": 0,
    "distance": 6.531915005756953,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-05",
    "Steps": 7223,
    "calories": 0,
    "distance": 5.7936,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-06",
    "Steps": 5935,
    "calories": 0,
    "distance": 4.761774192190294,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-07",
    "Steps": 11740,
    "calories": 0,
    "distance": 9.414437751215601,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-08",
    "Steps": 5731,
    "calories": 0,
    "distance": 4.601358784539343,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-09",
    "Steps": 6451,
    "calories": 0,
    "distance": 5.1727972788184085,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-10",
    "Steps": 8029,
    "calories": 0,
    "distance": 6.4328,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-11",
    "Steps": 8715,
    "calories": 0,
    "distance": 6.987476783836177,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-12",
    "Steps": 8496,
    "calories": 0,
    "distance": 6.808,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-13",
    "Steps": 7300,
    "calories": 0,
    "distance": 5.852020781507857,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-14",
    "Steps": 7104,
    "calories": 0,
    "distance": 5.69149152146584,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Daily": "2024-12-15",
    "Steps": 3993,
    "calories": 0,
    "distance": 3.2037084785341596,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  }
]
```
# Monthly (recordkey = 7b012e6e-ba2b-49c7-bc2e-473b7b58e72e)
```json
[
  {
    "Monthly": "2024-11",
    "Steps": 117638,
    "calories": 0,
    "distance": 94.2903207904855,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  },
  {
    "Monthly": "2024-12",
    "Steps": 111729,
    "calories": 0,
    "distance": 89.5817166376823,
    "recordkey": "7b012e6e-ba2b-49c7-bc2e-473b7b58e72e"
  }
]
```
# Daily (recordkey = e27ba7ef-8bb2-424c-af1d-877e826b7487)
```json
[
  {
    "Daily": "2024-11-14",
    "Steps": 2077,
    "calories": 0,
    "distance": 1.6632000000000002,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-15",
    "Steps": 7894,
    "calories": 0,
    "distance": 6.3216,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-16",
    "Steps": 9137,
    "calories": 0,
    "distance": 7.3152,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-17",
    "Steps": 2288,
    "calories": 0,
    "distance": 1.8336000000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-18",
    "Steps": 13682,
    "calories": 0,
    "distance": 10.955200000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-19",
    "Steps": 12214,
    "calories": 0,
    "distance": 9.780000000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-20",
    "Steps": 5371,
    "calories": 0,
    "distance": 4.3032,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-21",
    "Steps": 9486,
    "calories": 0,
    "distance": 7.5952,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-22",
    "Steps": 6515,
    "calories": 0,
    "distance": 5.2176,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-23",
    "Steps": 8233,
    "calories": 0,
    "distance": 6.5944,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-24",
    "Steps": 2351,
    "calories": 0,
    "distance": 1.8824,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-25",
    "Steps": 12556,
    "calories": 0,
    "distance": 10.055200000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-26",
    "Steps": 7670,
    "calories": 0,
    "distance": 6.142381151839544,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-27",
    "Steps": 7330,
    "calories": 0,
    "distance": 5.8696188481604565,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-28",
    "Steps": 7741,
    "calories": 0,
    "distance": 6.1976,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-29",
    "Steps": 8693,
    "calories": 0,
    "distance": 6.960800000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-11-30",
    "Steps": 12871,
    "calories": 0,
    "distance": 10.3088,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-01",
    "Steps": 2133,
    "calories": 0,
    "distance": 1.7095035680513488,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-02",
    "Steps": 12045,
    "calories": 0,
    "distance": 9.644096431948652,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-03",
    "Steps": 6734,
    "calories": 0,
    "distance": 5.3928,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-04",
    "Steps": 14740,
    "calories": 0,
    "distance": 11.8032,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-05",
    "Steps": 10787,
    "calories": 0,
    "distance": 8.6384,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-06",
    "Steps": 8652,
    "calories": 0,
    "distance": 6.9264,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-07",
    "Steps": 10257,
    "calories": 0,
    "distance": 8.215200000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-08",
    "Steps": 11640,
    "calories": 0,
    "distance": 9.3232,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-09",
    "Steps": 10898,
    "calories": 0,
    "distance": 8.7248,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-10",
    "Steps": 12877,
    "calories": 0,
    "distance": 10.3104,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-11",
    "Steps": 12700,
    "calories": 0,
    "distance": 10.1696,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-12",
    "Steps": 8792,
    "calories": 0,
    "distance": 7.042400000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-13",
    "Steps": 8331,
    "calories": 0,
    "distance": 6.6704,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-14",
    "Steps": 5344,
    "calories": 0,
    "distance": 4.28,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Daily": "2024-12-15",
    "Steps": 786,
    "calories": 0,
    "distance": 0.6304000000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  }
]
```
# Monthly (recordkey = e27ba7ef-8bb2-424c-af1d-877e826b7487)
```json
[
  {
    "Monthly": "2024-11",
    "Steps": 136109,
    "calories": 0,
    "distance": 108.99600000000001,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  },
  {
    "Monthly": "2024-12",
    "Steps": 136716,
    "calories": 0,
    "distance": 109.4808,
    "recordkey": "e27ba7ef-8bb2-424c-af1d-877e826b7487"
  }
]
```

