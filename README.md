# JungleSocks
Test taxt rates on jungle-socks.herokuapp.com

Jungle Socks Test Setup:

Instructions for Ubuntu Desktop 16.04 LTS:

Install Default JDK:
sudo apt-get install default-jdk

Download Eclipse:
https://www.eclipse.org/downloads/download.php?file=/oomph/epp/neon/R/eclipse-inst-linux64.tar.gz

Install Eclipse:
sudo cp ~/Downloads/eclipse-inst-linux64.tar.gz /opt/
cd /opt/
sudo tar -xvf eclipse-inst-linux64.tar.gz
sudo rm eclipse-inst-linux64.tar.gz
cd eclipse-installer/
./eclipse-inst
Choose Eclipes IDE for JAva Developers
Accept all defaults, licences, and certs.
Click Start Eclipse

Download Selenium Client & WebDriver Language Bindings:
http://selenium-release.storage.googleapis.com/3.0-beta3/selenium-java-3.0.0-beta3.zip
cd ~
mkdir ~/selenium-java-3.0.0-beta3
cp ~/Downloads/selenium-java-3.0.0-beta3.zip ~/selenium-java-3.0.0-beta3/
cd ~/selenium-java-3.0.0-beta3
unzip selenium-java-3.0.0-beta3.zip
rm selenium-java-3.0.0-beta3.zip

http://chromedriver.storage.googleapis.com/2.23/chromedriver_linux64.zip
cd ~
mkdir ~/chromedriver-2.24
cp ~/Downloads/chromedriver_linux64.zip ~/chromedriver-2.24/
cd ~/chromedriver-2.24
unzip chromedriver_linux64.zip
rm chromedriver_linux64.zip

Install Chrome:
https://www.google.com/chrome/browser/desktop/index.html
sudo dpkg -i ~/Downloads/google-chrome-stable_current_amd64.deb

Download JungleSocks.java from github:
https://github.com/aroots/JungleSocks/blob/master/JungleSocks.java

Create and configure Eclipse project.
File | New Java Project
	Project Name: JungleSocks
	Finish

Right-Click JungleSocks | Build Path | Add External Archive
	~/selenium-java-3.0.0-beta3/client-combined-3.0.0-beta3-nodeps.jar
	OK

Right-Click JungleSocks | Build Path | Add External Archive
	~/selenium-java-3.0.0-beta3/lib/*.*

Right-Click JungleSocks | New Class
	Package: com.JungleSocks.test
	Name: JungleSocks
	Finish

Replace contents of JungleSocks.java in the project
with the contents of JungleSocks.java from the github.

Edit this line with the path to the chromedriver in JungleSocks.java:
System.setProperty("webdriver.chrome.driver", "/home/abe/chromedriver-2.24/chromedriver");

Save

Run

