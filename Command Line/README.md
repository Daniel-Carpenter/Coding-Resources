*THE BELOW INFORMATION IS REPRODUCED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20).*

* [Data Science at the Command Line](https://www.datascienceatthecommandline.com/1e/chapter-3-obtaining-data.html) book


## Command Line

| Command                                              | Unix                                                                                                         | DOS                                                                                                                              |
|------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| Change directory                                     | `cd <directory path>` (could be relative path)                                                                 | `cd `                                                                                                                              |
| List files in directory                              | `ls  `                                                                                                         | `dir`                                                                                                                              |
| Move up one level in directory structure             | `cd .. `                                                                                                       | `cd ..`                                                                                                                            |
| Create new directory                                 | `mkdir`                                                                                                        | `md`                                                                                                                              |
| Create new file                                      | `touch filename`                                                                                               | `copy con filename`                                                                                                               |
| List current processes                               | `ps`                                                                                                           | `tasklist`                                                                                                                         |
| Kill a running process                               | `kill <process id>`                                                                                            | `Taskkill /PID <process id> /F  `                                                                                                  |
| Connect to remote machine via secure shell           | `ssh -p <port number> <user@hostname>`                                                                         | `<path to PuTTY.exe> -ssh <username@host> <port number>  `                                                                         |
| Transfer files to a remote machine (via Secure Copy) | `scp [options] <username1@source_host:directory1/filename1> <username2@destination_host:directory2/filename2>` | `pscp -scp [options] <username1@source_host:directory1/filename1> <username2@destination_host:directory2/filename2>`              |
| Submit a batch script                                | `srun <filename.sh>`                                                                                           | unlikely to do this. If need to, see [here](https://stackoverflow.com/questions/26522789/how-to-run-sh-on-windows-command-prompt) |

***

### Other Useful Command Line Prompts

#### Copying Files into a Single Files
Using `.csv` files, here is an example:

##### 1. Set working directory to folder path
```cmd
> cd folderPathHere_withoutQuotes
```

##### Copy all `.csv` Files to Single `.csv` File
```cmd
> copy *.csv combinedFileName_withoutQuotes.csv
```

Done!

***
