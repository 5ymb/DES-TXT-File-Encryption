<div align="center">
<h1>🛡️ Java DES File Encryptor</h1>

<p>
  A lightweight, GUI-based Java application that encrypts and decrypts text files using the 
  <strong>Data Encryption Standard (DES)</strong> algorithm. This project demonstrates symmetric key generation, 
  file handling, and a clean user interface design using Java Swing.
</p>
 <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java">
 <img src="https://img.shields.io/badge/Security-Cryptography-blue?style=for-the-badge" alt="Cryptography">
</div>
<hr>

<h2>✨ Features</h2>
<ul>
  <li><strong>GUI File Selection:</strong> Utilizes <code>JFileChooser</code> to let users easily browse and select target files.</li>
  <li><strong>Base64 Encoding:</strong> Safely handles raw binary ciphertext by encoding it into readable Base64 format for display.</li>
  <li><strong>Clean UI Output:</strong> Results are displayed in neatly proportioned, word-wrapped popup windows (no infinitely stretching boxes!).</li>
  <li><strong>End-to-End Test:</strong> Automatically reads, encrypts, and decrypts the selected file to verify data integrity.</li>
</ul>

<hr>

<h2>⚙️ Prerequisites</h2>
<p>To compile and run this application, you will need:</p>
<ul>
  <li><strong>Java Development Kit (JDK):</strong> Version 8 or higher.</li>
</ul>

<hr>

<h2>🚀 How to Run</h2>
<p>Follow these steps to run the application from your terminal or command prompt:</p>

<ol>
  <li><strong>Clone the repository:</strong><br>
    <pre><code>git clone https://github.com/5ymb/DES-TXT-File-Encryption.git</code></pre>
  </li>
  <li><strong>Navigate to the directory:</strong><br>
    <pre><code>cd DES-TXT-File-Encryption</code></pre>
  </li>
  <li><strong>Compile the Java file:</strong><br>
    <pre><code>javac DES.java</code></pre>
  </li>
  <li><strong>Run the application:</strong><br>
    <pre><code>java DES</code></pre>
  </li>
</ol>

<p><em>Once running, a file chooser window will appear. Select a <code>.txt</code> file to see the encryption and decryption in action!</em></p>

<hr>

<h2>⚠️ Security Disclaimer</h2>
<blockquote>
  <p><strong>Note on DES:</strong> This project uses the Data Encryption Standard (DES), which utilizes a 56-bit key. 
  DES is considered cryptographically outdated and vulnerable to modern brute-force attacks. 
  This code is intended for <strong>educational purposes only</strong>. For securing real-world sensitive data, 
  always use modern standards like <strong>AES-256</strong>.</p>
</blockquote>

<hr>

<p align="center">
  <i>Built with Java Swing and Java Cryptography Architecture (JCA).</i>
</p>
