package org.surovskiy.example;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

/**
 * TODO: write javadoc
 *
 * @author Evgeniy Surovskiy
 */
public class ApplicationStarter {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new PhotoBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
