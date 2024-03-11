package semi02.project.rain;

import semi02.project.utils.Define;

public class bus implements Basic {
    private static bus instance;

    private bus() {}

    public static synchronized bus getInstance() {
        if (instance == null) {
            instance = new bus();
        }
        return instance;
    }

    @Override
    public int calculateLatePercentage( int rainfallPercentage) {
        int additionalLatePercentage = 0;

        if (rainfallPercentage >= 90) {
            additionalLatePercentage = 50; // 강수량이 90% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 70) {
            additionalLatePercentage = 40; // 강수량이 70% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 50) {
            additionalLatePercentage = 30; // 강수량이 50% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 30) {
            additionalLatePercentage = 20; // 강수량이 30% 이상일 때 추가 지각 확률
        } else if (rainfallPercentage >= 10) {
            additionalLatePercentage = 10; // 강수량이 10% 이상일 때 추가 지각 확률
        }

        return additionalLatePercentage;
    }
}