package org.example.ll;

import java.util.HashMap;
import java.util.Map;

public class Command {
    private final String actionName;
    private final Map<String, String> params;
    public Command(String cmd) {
        String[] cmdBits = cmd.split("\\?");    //cmd로 받아온 문자열을 ?를 기준으로 나눈 것을 cmdBits에 대입
        this.actionName = cmdBits[0];   //cmdBits에서 왼쪽 즉, 배열의 첫번째 값은 actionName(명령어)로 설정
        this.params = new HashMap<>();

        String queryString = cmdBits[1];    //cmdBits에서 오른쪽 즉, 배열의 두번째 값은 queryString(id설정 쿼리)로 설정
        String[] queryStringBits = queryString.split("&");  //queryString을 &를 기준으로 나눠 배열 queryStringBits에 대입
        for (String queryStringBit : queryStringBits) {
            String[] keyValue = queryStringBit.split("=", 2);   // 예를 들면 key값에 id = "5=5"값이 들어가면 =을 기준으로 나눴기 때문에
                                                                           // 3등분이 되므로 =을 기준으로 최대 2개로만 나눌수 있게 설정
            this.params.put(keyValue[0], keyValue[1]);  //2개로 나눈 값을 순서대로 Map 컬렉션 자료구조에 대입
        }
    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String id) {
        return params.get(id);  //params Map 자료구조에서 id에 해당하는 값 가져오기
    }

    public String getParam(String id, String none) {
        return params.getOrDefault(id, none);
    }

    public int getParamAsInt(String id) {
        return Integer.parseInt(params.get(id));    //params Map 자료구조에서 id값을 가져올때 String 값이므로 int로 변환
    }
}
