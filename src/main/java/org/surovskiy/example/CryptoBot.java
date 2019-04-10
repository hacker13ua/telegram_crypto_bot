package org.surovskiy.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * TODO: write javadoc
 *
 * @author Evgeniy Surovskiy
 */
public class CryptoBot extends TelegramLongPollingBot {

    private ICryptoService cryptoService = new SimpleCryptoService();

    public void onUpdateReceived(final Update update) {
        if (update.hasInlineQuery()) {

            final String text = update.getInlineQuery().getQuery();
            System.out.println(text);
            final String encryptedMessage = cryptoService.getEncryptedMessage(text);
            final InlineQueryResultArticle inlineQueryResult = new InlineQueryResultArticle();
            inlineQueryResult
                    .setId("1")
                    .setTitle(encryptedMessage)
                    .setInputMessageContent(new InputTextMessageContent()
                    .setMessageText(encryptedMessage));
            final AnswerInlineQuery finalAnswer = new AnswerInlineQuery();
            finalAnswer.setInlineQueryId(update.getInlineQuery().getId())
                    .setResults(inlineQueryResult);
            try {
                execute(finalAnswer);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    public String getBotUsername() {
        return "crypto_la_bot";
    }

    public String getBotToken() {
        return "899955232:AAGSjtTh4QbPKwbmk7zJ_hdGTUjc50JwExQ";
    }
}
