package telegrambot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
public class Telegrambot extends TelegramLongPollingBot {
    
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegrambot = new TelegramBotsApi();
        try{
            telegrambot.registerBot(new Telegrambot());
        } catch(TelegramApiException e){
            System.err.println("Registratsiya qilishda xatolik");
        }
    }

    @Override
    public String getBotToken() {
        return "708735688:AAEFE_h-a2O1iTlrZW73B2kLrg1o51lTVB0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String xabar = null;
        SendMessage msg = new SendMessage().setParseMode(ParseMode.MARKDOWN);
        String message = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        
        Integer message_id = update.getMessage().getMessageId();
        if(update.hasMessage() && update.getMessage().hasText()){
            if(message.equalsIgnoreCase("salom")){
                xabar = "Alik";
            }
            if(message.equalsIgnoreCase("id")){
                msg.setReplyToMessageId(message_id);
                xabar = "Sizning id raqamingiz:\n" + update.getMessage().getFrom().getId();
            }
            if(message.equalsIgnoreCase("asad")){
                xabar = "Xa nima deysan";
            }
            if(message.equalsIgnoreCase("ism")){ xabar = "Sizning ismingiz:\t" + 
                    update.getMessage().getFrom().getFirstName().toUpperCase(); }
            if(xabar!=null){
                msg.setChatId(chat_id);
                msg.setText(xabar);
                try{
                    execute(msg);
                } catch(TelegramApiException e){
                    System.err.println("Xabar jo'natishda xatolik");
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "my_birinchi_amazing_robot";
    }
}