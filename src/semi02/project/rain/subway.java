package semi02.project.rain;

import semi02.project.utils.Define;

public class subway implements Basic {
    private static subway instance;

    private subway() {}

    public static synchronized subway getInstance() {
        if (instance == null) {
            instance = new subway();
        }
        return instance;
    }

    @Override
    public int calculateLatePercentage(int rainfallPercentage) {
        int additionalLatePercentage = 0;

        if (rainfallPercentage >= 90) {
            additionalLatePercentage = 7; // 강수량이 90% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 70) {
            additionalLatePercentage = 6; // 강수량이 70% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 50) {
            additionalLatePercentage = 5; // 강수량이 50% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 30) {
            additionalLatePercentage = 4; // 강수량이 30% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 10) {
            additionalLatePercentage = 3; // 강수량이 10% 이상일 때 추가 지각 확률
        }

        return additionalLatePercentage;
    }
}