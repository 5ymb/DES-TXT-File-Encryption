import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import java.util.Base64;

class DES {

    byte[] skey = new byte[1000];
    String skeyString;
    static byte[] raw;
    String encryptedData, decryptedMessage;

    public DES() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a text file to encrypt");
            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToEncrypt = fileChooser.getSelectedFile();
                String filePath = fileToEncrypt.getAbsolutePath();
                System.out.println("File selected: " + filePath + "\n");

                generateSymmetricKey();

                byte[] ibyte = Files.readAllBytes(Paths.get(filePath));

                byte[] ebyte = encrypt(raw, ibyte);
                encryptedData = Base64.getEncoder().encodeToString(ebyte);
                System.out.println("Encrypted message: " + encryptedData);

                showWrappedMessageDialog("Encrypted Data", encryptedData);

                byte[] dbyte = decrypt(raw, ebyte);
                decryptedMessage = new String(dbyte);
                System.out.println("\nDecrypted message: \n" + decryptedMessage);

                showWrappedMessageDialog("Decrypted Data", decryptedMessage);

            } else {
                System.out.println("File selection was cancelled.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showWrappedMessageDialog(String title, String message) {
        JTextArea textArea = new JTextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setRows(8);
        textArea.setColumns(40);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }

    void generateSymmetricKey() {
        try {
            Random r = new Random();
            int num = r.nextInt(10000);
            String knum = String.valueOf(num);
            byte[] knumb = knum.getBytes();
            skey = getRawKey(knumb);
            skeyString = Base64.getEncoder().encodeToString(skey);
            System.out.println("DES Symmetric key = " + skeyString);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("DES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        kgen.init(56, sr);
        SecretKey skey = kgen.generateKey();
        raw = skey.getEncoded();
        return raw;
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        return cipher.doFinal(clear);
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return cipher.doFinal(encrypted);
    }

    public static void main(String args[]) {
        new DES();
    }
}