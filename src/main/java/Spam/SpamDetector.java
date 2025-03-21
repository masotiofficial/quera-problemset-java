package Spam;

import java.util.regex.Pattern;

public class SpamDetector {
    public SpamType[] detectSpams(Message[] messages) {
        //todo
        SpamType[] result = new SpamType[messages.length];

        for (int i = 0; i < messages.length; i++) {
            result[i] = detectSpam(messages[i]);
        }

        return result;
    }

    public SpamType detectSpam(Message message) {
        boolean invalidSender = isInvalidSender(message.getSenderId());
        boolean invalidContent = isInvalidContent(message.getContent());

        if (invalidSender && invalidContent) {
            return SpamType.FULLY_INVALID;
        } else if (invalidSender) {
            return SpamType.INVALID_SENDER;
        } else if (invalidContent) {
            return SpamType.INVALID_CONTENT;
        } else {
            return SpamType.NOT_SPAM;
        }
    }

    public boolean isInvalidSender(String senderId) {
        return Pattern.matches("\\d+", senderId);
    }

    private boolean isInvalidContent(String content) {
        int otherCount = 0;
        for (char c : content.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c)) {
                otherCount++;
            }
        }

        boolean hasSpamWord = Pattern.compile("spam", Pattern.CASE_INSENSITIVE)
                .matcher(content)
                .find();

        return (otherCount > content.length() / 2) && (hasSpamWord);
    }
}