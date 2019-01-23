package org.surovskiy.example;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.WebhookBot;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * TODO: write javadoc
 *
 * @author Evgeniy Surovskiy
 */
public class PhotoBot extends TelegramLongPollingBot {
    private static final String URL = "https://pixabay.com/api/?" +
            "key=11354413-a29884c40a2b9515cea6ff2cc&per_page=5&q=";

    public void onUpdateReceived(final Update update) {
        final String text = update.getMessage().getText();
        System.out.println(text);
        final SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId());
        try {
            sendPhoto.setPhoto("photo", getImg(text));
            execute(sendPhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputStream getImg(final String text) throws IOException {
        final String s = IOUtils.toString(new URL(URL + text), "UTF-8");
        final String ingString = new JSONObject(s).getJSONArray("hits")
                .getJSONObject(0)
                .getString("largeImageURL");
        return new URL(ingString).openStream();
    }

    public String getBotUsername() {
        return "brain_academy_example_bot";
    }

    public String getBotToken() {
        return "726644118:AAEkH-ZeLbSz1zj6DGLNsA4JpBeaX1FWCTU";
    }
}
