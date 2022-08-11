import java.io.*;
import java.util.Scanner;

class Trans{
  int No;
  int gas=100;
  int speed=0;
  int max_p;
  int passenger=0;
  int allFare=0;
  boolean b_run=true;
  
  public Trans(){}
  public Trans(int No) {
	  this.No = No;
  }

  //시간이 n만큼 변했을 때, 운행속도*거리(1)*시간n 만큼 움직였다고 생각하고 다시 값 확인하기
  void refresh(){
    
  }
  
  //승객탑승(택시랑 버스 다르게 구현해야 함 오버라이딩)
  boolean plusPassenger(int n){
	  if(this.b_run=false) {
		  System.out.println("운행중인 버스가 아닙니다.");
		  return false;
	  }
	  else if(passenger+n>max_p) {
		  System.out.println("최대 승객 수 초과");
		  return false;
	  }
	  else {
		  passenger+=n;
		  System.out.println("현재 탑승 승객 수는 "+passenger+"이고, 잔여 승객 수는 "+(max_p-passenger)+"입니다.");
		  return true;
	  }
	  
  }
  
  //속도변경(택시랑 버스 다르게 구현해야 함 오버라이딩)
  boolean speedChange(int n) {
	  if(gas<10) {
		  System.out.println("주유량을 확인해주세요.");
		  return false;
	  }
	  else {
		  speed+=n;
		  System.out.println("속도가 "+speed+"으로 변경되었습니다.");
		  return true;
	  }
	  
  }
  
  //주유량 변화
  void gasChange(int n) {
	  gas+=n;
	  System.out.println("주유량이 "+gas+"으로 변경되었습니다.");
  }
  
  void startRun(){
  	if(gas<10) {
	  System.out.println("주유 필요");
  	}
  	else {
	  b_run=true;
  	}
}
  void stopRun(){
    b_run=false;
  }
  void showInfo() {
	  System.out.println(No+"번");
	  System.out.println("현재 주유량 :"+gas);
	  System.out.println("현재 승객수 :"+passenger);
	  System.out.println("현재 속도 :"+speed);
	  System.out.println("누적 요금 :"+allFare);
	  System.out.println("운영 상태 :"+b_run);
	  
  }

}


public class num2 {
	public static void main(String[] args) throws IOException{
    
		
	//만들고 싶은 버스의 개수와 택시의 개수를 입력하시오
	System.out.println("생성할 버스의 수와 택시의 수를 차례로 입력하세요 ex)3 5");
	Scanner scin = new Scanner(System.in);
	int busNo = scin.nextInt();
	int taxiNo = scin.nextInt();
	
	
//	@@@@@@@@버스 클래스 생성을 어떻게 해야 할지 모르겠음 !내가 원하는 개수만큼! (!클래스 이름을 설정해서!)@@@@@@@@@@
	
//	switch(busNo) {
//	case 1:
//		Bus b1 = new Bus(1);
//		break;
//	case 2:
//		Bus b11 = new Bus(1);
//		Bus b2 = new Bus(2);
//		break;
//	}
// 함수 싹 뒤집어 엎어야 함. class도 넘겨받을 수 있도록@@@@@@@@@@@

	Bus b1 = new Bus(1);
	Taxi t1 = new Taxi(1);
	
	
	//그러고 나면 몇번의 버스와 몇번의 택시가 만들어졌는지 출력(번호는 class 이름과 통일?)
	System.out.println("운행가능한 버스 "+busNo+"대와 택시"+taxiNo+"대가 생성되었습니다.");
	
	
//	System.out.println("No: b1, b2, t1");
	
		
	//원하는 버스or택시의 번호를 입력하세요
	System.out.println("상태를 변경하거나 확인하고 싶은 교통수단을 입력하세요. 멈추고 싶을 떄에는 stop을 입력해주세요. ex)bus, taxi, stop");
	Scanner in1 = new Scanner(System.in);
	String trans = in1.next();
	
	
	while(!trans.equals("stop")){	
//	원하는 @@의 번호를 입력해주세요.
//	System.out.println(trans+"의 번호를 입력해주세요. ex)1");
//	Scanner in2 = new Scanner(System.in);
//	int tNo = in2.nextInt();
	
	//함수가 뭐가 있는지 출력해주고, 원하는 기능의 번호를 입력해주세요 
	if(trans.equals("bus")) {
		System.out.println("원하는 기능의 번호를 입력하세요. ex)4");
		System.out.println("1.운행시작 2.속도변경 3.주유량변경 4.승객탑승 5.운행중단");
		Scanner in3 = new Scanner(System.in);
		int funtionNo = in3.nextInt();
		
		switch(funtionNo) {
		case 1:
			b1.startRun();
			break;
		case 2:
			System.out.println("추가 혹은 감소하고 싶은 속도를 입력하세요. ex)3, -2");
			Scanner in4 = new Scanner(System.in);
			int sp = in4.nextInt();
			if(b1.speedChange(sp)) {
				System.out.println("속도가 "+b1.speed+"으로 변경되었습니다.");
				}
			break;
		case 3:
			System.out.println("추가 혹은 감소하고 싶은 주유량 입력하세요. ex)3, -2");
			Scanner in5 = new Scanner(System.in);
			int gs = in5.nextInt();
			b1.gasChange(gs);
			break;
		case 4:
			System.out.println("추가 혹은 감소하고 싶은 승객의 수를 입력하세요. ex)3, -2");
			Scanner in6 = new Scanner(System.in);
			int p = in6.nextInt();
			if(b1.plusPassenger(p)) {
				b1.allFare+=p*b1.perFare;
			}
			break;
		case 5:
			b1.startRun();
			break;
		default:
			System.out.println("기능의 번호를 다시 확인해주세요.");
			break;
		}
		
	}
	else if(trans.equals("taxi")) {
		System.out.println("원하는 기능의 번호를 입력하세요. ex)4");
		System.out.println("1.운행시작 2.속도변경 3.주유량변경 4.승객탑승 5.요금결제 6.운행중단");
		Scanner in3 = new Scanner(System.in);
		int funtionNo = in3.nextInt();
		
		switch(funtionNo) {
		case 1:
			t1.startRun();
			break;
		case 2:
			System.out.println("추가 혹은 감소하고 싶은 속도를 입력하세요. ex)3, -2");
			Scanner in4 = new Scanner(System.in);
			int sp = in4.nextInt();
			if(t1.speedChange(sp)) {
			}
			break;
		case 3:
			System.out.println("추가 혹은 감소하고 싶은 주유량 입력하세요. ex)3, -2");
			Scanner in5 = new Scanner(System.in);
			int gs = in5.nextInt();
			t1.gasChange(gs);
			break;
		case 4:
			System.out.println("추가 혹은 감소하고 싶은 승객의 수를 입력하세요. ex)3, -2");
			Scanner in6 = new Scanner(System.in);
			int p = in6.nextInt();
			if(t1.plusPassenger(p)) {
				System.out.println("목적지와 거리를 입력하세요 ex)서울역, 12");
				Scanner in7 = new Scanner(System.in);
				t1.desitnation = in7.next();
				t1.distance = in7.nextInt();
				
				t1.clacFare(t1.distance);
			}
			break;
		case 5:
			t1.pay();
			
		case 6:
			t1.startRun();
			break;
		default:
			System.out.println("기능의 번호를 다시 확인해주세요.");
			break;
		}
	}
	else {
		System.out.println("교통수단을 다시 확인해주세요.");
	}
	
	System.out.println("상태를 변경하거나 확인하고 싶은 교통수단을 입력하세요. 멈추고 싶을 떄에는 stop을 입력해주세요. ex)bus, taxi, stop");
	Scanner in0 = new Scanner(System.in);
	trans = in0.next();
	}//while문 의 끝
	
   
	
  }
}