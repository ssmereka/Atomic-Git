echo Enter your Github email address
read gitEmail
cd ~/.ssh
read
mkdir key_backup
cp id_rsa* key_backup
rm id_rsa*
ssh-keygen -t rsa -C $gitEmail
echo Copy text displayed in Notepad [Do not save changes to file]
echo " "
echo ... Press Enter ...
start notepad.exe "C:\Users\Scott\.ssh\id_rsa.pub"
read
echo On GitHub website:
echo 0. Login
echo 1. Add another public key
echo 2. Paste text into "Key" field and enter a title
echo 3. Click "Add key"
start https://github.com/account/ssh
start notepad.exe "C:\Users\Scott\.ssh\id_rsa.pub"
echo " "
echo ... Press Enter...
echo Testing connection
ssh git@github.com
echo Complete
read


