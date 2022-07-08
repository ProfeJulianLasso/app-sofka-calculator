package org.sofka.calculator.utilities;

import org.jboss.logging.Logger;

public class MessagesCalculator {

    private static final Logger logger = Logger.getLogger(MessagesCalculator.class);
    private static MessagesCalculator instance = null;

    public static MessagesCalculator getInstance() {
        if (instance instanceof MessagesCalculator) {
            return instance;
        } else {
            instance = new MessagesCalculator();
        }
        return instance;
    }

    public void showWelcome() {
        logger.info("Esta es una calculadora en Java bajo el paradigma de POO");
    }

    public void showGetNumber() {
        logger.info("Digite un número:");
    }

    public void showSelectAction() {
        logger.info("Digite una opción:\n[+] [-] [*] [/] [%] [.]");
    }

    public void showAnswer(Double answer) {
        logger.info("La respuesta es: " + answer.toString());
    }

    public void incorrectChoice() {
        logger.warn("La opción escogida es incorrecta");
    }

    public void showMessage(String message) {
        logger.info(message);
    }

    public void pressAnyKeyToContinue() {
        logger.info("Presione cualquier tecla para continuar");
        try {
            System.in.read();
        } catch (Exception exception) {
            throw new MyException(exception.getMessage(), exception);
        }
    }
}
