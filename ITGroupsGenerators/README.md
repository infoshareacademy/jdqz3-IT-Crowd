**How add our changes.**
1. git clone https://github.com/infoshareacademy/jdqz3-IT-Crowd.git
2. git status (you have to be on master)
3. git checkout -b feature_nameOfYourChange 
4. Add your java program in IJ:
    * generators in _pl.infoshare.utils_ 
    * add your calling the program in App
5. git status (check name of branch and files you added if ok then...)
6. git add .
7. git commit -m "name of your changes"
8. git push --set-upstream origin feature_nameOfYourChange
9. pull request on GitHub