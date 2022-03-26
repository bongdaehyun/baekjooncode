import java.util.*;

public class programmers_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int lastTime=getMin("23:59");


        //주차되어있는 차
        HashMap<String,Integer> parking=new HashMap<>();
        HashMap<String,Integer> recordMin=new HashMap<>();
        //차들 list
        List<String>cars=new ArrayList<>();

        for(String record:records){
            String []rc=record.split(" ");
            String time=rc[0];
            String car=rc[1];
            String InOut=rc[2];


            //새롭게 들어온차들에 대한 정보 저장
            if(!cars.contains(car)){
                cars.add(car);
                recordMin.put(car,0);
            }

            if(parking.containsKey(car)){
                recordMin.put(car,recordMin.get(car)+(getMin(time)-parking.get(car)));
                parking.remove(car);
            }else{
                parking.put(car,getMin(time));
            }

        }
        for(String key:parking.keySet()){
            recordMin.put(key,recordMin.get(key)+(lastTime-parking.get(key)));
        }
        int answer[]=new int[cars.size()];
        Collections.sort(cars);
        // System.out.println(recordMin);
        int idx=0;
        //주차 요금 계산
        for(String car:cars){

            int parkingTime=recordMin.get(car);
            int price=fees[1];

            //기본 시간이하
            if(parkingTime<=fees[0]){
                answer[idx++]=price;
            }else{

                //System.out.println(parkingTime+","+Math.ceil((parkingTime-fees[0])/fees[2]));
                price+=(int)Math.ceil((double)(parkingTime-fees[0])/fees[2])*fees[3];

                answer[idx++]=price;
            }
            // System.out.println(car+" : "+price);
        }



        return answer;
    }

    private int getMin(String time){
        String []HM=time.split(":");
        return Integer.parseInt(HM[0])*60+Integer.parseInt(HM[1]);
    }
}

