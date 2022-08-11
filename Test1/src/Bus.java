
public class Bus extends Trans{
  
  int perFare;
  
  Bus(){
	  super();
	  max_p=30;
	  passenger=0;
	  perFare = 1500;
  }
  Bus(int No){
	  super(No);
	  max_p=30;
	  perFare=1500;
  }
  
  
  //버스 상태 변경(주유량 확인해서)
  
//  //승객 탑승 없어도 되지않나? 
//  @Override
//  boolean plusPassenger(int n){
//	  passenger+=n;
//  }

  //INfo보여주는거
  void showInfo() {
	  System.out.println(No+"번 버스");
	  System.out.println("현재 주유량 :"+gas);
	  System.out.println("현재 승객수 :"+passenger);
	  System.out.println("현재 속도 :"+speed);
	  System.out.println("운영 상태 :"+b_run);
	  
  }
}