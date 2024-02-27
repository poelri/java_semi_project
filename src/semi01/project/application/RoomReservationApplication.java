package semi01.project.application;
import java.util.ArrayList; // ArrayList import 추가

import semi01.project.DoubleRoomreservation;
import semi01.project.RoomReservation;
import semi01.project.SweetRoomReservation;
import semi01.project.TwinRoomReservation;
import java.util.Scanner;


public class RoomReservationApplication {

    private static ArrayList<RoomReservation> ReservationList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in); // Scanner 객체 생성


    public static void main(String[] args) {
        /*
        RoomReservation roomReservationYona = new DoubleRoomreservation(1010, "Yona",3);
        RoomReservation roomReservationHong = new TwinRoomReservation(10020, "Hong",1);

        ReservationList.add(roomReservationYona);
        ReservationList.add(roomReservationHong);
        */
        boolean run = true;
        while (run) {
            System.out.println("----------------------------------------------");
            System.out.println("1.예약하기 | 2. 모든 예약 정보 | 3.모든 룸 정보 | 4.특정 고객 예약정보 | 5.종료");
            System.out.println("----------------------------------------------");

            System.out.print("선택>");

            int selectNo = scanner.nextInt(); //입력받음

            switch (selectNo) {
                case 1: createAccount(); break;
                case 2: showAllReservations(); break;
                case 3: showAllRoominfo(); break;
                case 4: System.out.print("찾으시려는 고객의 ID를 입력해주세요: ");
                    int customerId = scanner.nextInt();
                    findCustomerId(customerId);
                    break;
                case 5 :
                    run=false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }

        System.out.println("프로그램 종료");
    }

        // 스캐너로 예약 정보 입력 받기
    private static void createAccount(){
        System.out.println("룸 예약을 진행할께요~");
        System.out.print("고객님의 ID를 입력해주세요");
        int customerID =scanner.nextInt();
        scanner.nextLine();

        System.out.println("예약하 실 고객님의 성함을 입력해주세요 : ");
        String customerName = scanner.nextLine();

        System.out.println("투숙 하실 인원수를 입력해주세요 : ");
        int headcount = scanner.nextInt();
        System.out.println("예약 일 수를 입력해주세요: ");
        int night = scanner.nextInt();

        System.out.println("객실 등급을 선택해주세요 (Single, Double, Twin, Sweet) : ");
        scanner.nextLine();
        String customerGrade = scanner.nextLine();

        int price = 0;

        RoomReservation roomReservation;
        switch (customerGrade.toLowerCase()){ // 사용자가 입력한 입력값을 전부 소문자로 변환하는것
            case "single":
                roomReservation = new RoomReservation(customerID,customerName,night,headcount,customerGrade);
                break;
            case "double":
                roomReservation = new DoubleRoomreservation(customerID,customerName,night,headcount,customerGrade);
                break;
            case "twin":
                roomReservation = new TwinRoomReservation(customerID,customerName,night,headcount,customerGrade);
                break;
            case "sweet":
                roomReservation = new SweetRoomReservation(customerID,customerName,night,headcount,customerGrade);
                break;
            default:
                System.out.println("잘못된 객실 등급입니다");
                return;
        }
        if (!(headcount > roomReservation.getHeadcount())) {
            ReservationList.add(roomReservation);
            showReservation();
        }

    }



    public static void showReservation() {
        System.out.println("---------예약 정보 출력-------");
        for (RoomReservation roomReservation : ReservationList) {

            System.out.println("예약자 ID: " + roomReservation.getCustomerID());
            System.out.println("예약자 성함: " + roomReservation.getCustomerName());
            System.out.println("객실 등급 : " + roomReservation.getCustomerGrade());
            System.out.println("숙박 일 수: " + roomReservation.getNight());
            System.out.println("조식 제공 여부 : " + roomReservation.getMeal());
            System.out.println("지불 금액 : " + roomReservation.calcPrice(roomReservation.getNight()));

            System.out.println("--------------------------------");
        }
    }

    private static void showAllReservations() {
        if (ReservationList.isEmpty()) {
            System.out.println("등록된 예약이 없습니다.");
            return;
        }

        System.out.println("---------모든 예약 정보 출력-------");
        for (RoomReservation roomReservation : ReservationList) {
            System.out.println("예약자 ID: " + roomReservation.getCustomerID());
            System.out.println("예약자 성함: " + roomReservation.getCustomerName());
            System.out.println("객실 등급 : " + roomReservation.getCustomerGrade());
            System.out.println("숙박 일 수: " + roomReservation.getNight());
            System.out.println("조식 제공 여부 : " + roomReservation.getMeal());
            System.out.println("지불 금액 : " + roomReservation.calcPrice(roomReservation.getNight()));
            System.out.println("--------------------------------");
        }
    }

    private static void showAllRoominfo(){
        System.out.println("1. Single Room 정보:");
        RoomReservation singleRoom = new RoomReservation(0, "", 0, 1, "Single");
        System.out.println(" - 헤드카운트: " + singleRoom.getHeadcount());
        System.out.println(" - 조식 제공 여부: " + singleRoom.getMeal());
        System.out.println(" - 가격: " + singleRoom.calcPrice(1));
        System.out.println();

        System.out.println("2. Double Room 정보:");
        DoubleRoomreservation doubleRoom = new DoubleRoomreservation(0, "", 0, 2, "Double");
        System.out.println(" - 헤드카운트: " + doubleRoom.getHeadcount());
        System.out.println(" - 조식 제공 여부: " + doubleRoom.getMeal());
        System.out.println(" - 가격: " + doubleRoom.calcPrice(1));
        System.out.println();

        System.out.println("3. Twin Room 정보:");
        TwinRoomReservation twinRoom = new TwinRoomReservation(0, "", 0, 2, "Twin");
        System.out.println(" - 헤드카운트: " + twinRoom.getHeadcount());
        System.out.println(" - 조식 제공 여부: " + twinRoom.getMeal());
        System.out.println(" - 가격: " + twinRoom.calcPrice(1));
        System.out.println();

        System.out.println("4. Sweet Room 정보:");
        SweetRoomReservation sweetRoom = new SweetRoomReservation(0, "", 0, 1, "Sweet");
        System.out.println(" - 조식 제공 여부: " + sweetRoom.getMeal());
        System.out.println(" - 가격: " + sweetRoom.calcPrice(1));
        System.out.println();
    }
    private static void findCustomerId(int customerId) {
        boolean found = false;
        for (RoomReservation roomReservation : ReservationList) {
            if (roomReservation.getCustomerID() == customerId) {
                found = true;
                System.out.println("고객 ID에 해당하는 예약 정보:");
                System.out.println("예약자 ID: " + roomReservation.getCustomerID());
                System.out.println("예약자 성함: " + roomReservation.getCustomerName());
                System.out.println("객실 등급 : " + roomReservation.getCustomerGrade());
                System.out.println("숙박 일 수: " + roomReservation.getNight());
                System.out.println("조식 제공 여부 : " + roomReservation.getMeal());
                System.out.println("지불 금액 : " + roomReservation.calcPrice(roomReservation.getNight()));
                System.out.println("--------------------------------");
                break; // 고객 ID로 예약 정보를 찾았으므로 루프 종료
            }
        }
        if (!found) {
            System.out.println("해당하는 고객 ID로 예약된 정보가 없습니다.");
        }
    }



}
