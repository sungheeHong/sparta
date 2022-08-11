public class Taxi extends Trans{
  
  String desitnation;
  static int minDistance = 1;
  int distance;
  static int minFare = 3000;
  static int perFare = 1000;
  int nowFare;
  
  Taxi(){
	  super();
	  max_p=4;
	  passenger=0;
	  nowFare = 0;
	  
  }
  Taxi(int No){
	  super(No);
	  this.No = No;
	  max_p=4;
	  passenger=0;
	  nowFare = 0;
	  
  }

@Override
boolean plusPassenger(int n){
	//상태가 운행중인 경우
	if(b_run==false) {
		System.out.println("탑승 불가");
		return false;
	}
	else {
	  passenger+=n;
	  b_run=false;
	  System.out.println("현재 탑승 승객 수는 "+passenger+"이고, 잔여 승객 수는 "+(max_p-passenger)+"입니다.");
	  return true;
	}
}

    
  //거리당 요금 추가
  void clacFare(int distance) {
	  nowFare = minFare + (distance-minDistance)*perFare;
  }
  
  //요금 결제
  int pay() {
	  int temp = nowFare;
	  allFare +=nowFare;
	  passenger=0;
	  nowFare = 0;
	  System.out.println("주유량 :"+gas);
	  System.out.println("누적요금 :"+allFare);
	  return temp;
  }
}