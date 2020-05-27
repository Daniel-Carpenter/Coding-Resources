PLEASE NOTE THAT THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'S REPOSITORY LOCATED [HERE](https://github.com/tyleransom/DScourseS20), with my personal additions here.


### Command Line

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


### Git and GitHub tutorial

Git and GitHub tutorial tutorial on using [Git and GitHub.com](https://github.com/tyleransom/DScourseS20/blob/master/Productivity/git_tutorial.pdf) (reproduced with permission from [Rick Evans](https://github.com/rickecon) at U Chicago). Git is a powerful version control software that comes natively installed on many machines and is widely used. GitHub.com is the most widely used online platform for hosting open source projects and integrating with Git software. Git has a significant learning curve, but it is essential for large collaborations that involve software development.

* [Git](https://xkcd.com/1597/)
* [Git Commit](https://xkcd.com/1296/)

| Functionality                                               | Git Command                                                      |
|-------------------------------------------------------------|------------------------------------------------------------------|
| See active branch and uncommitted changes for tracked files | `git status -uno`                                                  |
| Change branch                                               | `git checkout <branch name>`                                       |
| Create new branch and change to it                          | `git checkout -b <new branch name>`                                |
| Track file or latest changes to file                        | `git add <filename>`                                               |
| Commit changes to branch                                    | `git commit -m "message describing changes" `                      |
| Push committed changes to remote branch                     | `git push origin <branch name>`                                |
| Merge changes from master into development branch           | `(change working branch to master, then…) git merge <branch name>` |
| Merge changes from development branch into master           | (change to development branch, then…) `git merge master`           |
| List current tags                                           | `git tag`                                                          |
| Create a new tag                                            | `git tag -a v<version number> -m "message with new tag"`           |
| Pull changes from remote repo onto local machine            | `git fetch upstream`                                               |
| Merge changes from remote into active local branch          | `git merge upstream/<branch name>`                                 |
| Clone a remote repository                                   | `git clone <url to remote repo>`                                  |



## Other Useful Links

* [LaTeX math symbols](http://web.ift.uib.no/Teori/KURS/WRK/TeX/symALL.html)
* [Typesetting equations in TeX](http://moser-isi.ethz.ch/docs/typeset_equations.pdf)
* [Pimp my Editor](http://slides.com/nicklang/pimp-my-editor#/) (Sublime Text focused, but may similar plug-ins/features available in Npp, Atom, or Vim)
* [Unix commands](https://files.fosswire.com/2007/08/fwunixref.pdf)
* [DOS commands](https://en.wikipedia.org/wiki/List_of_DOS_commands)
* [Git Basics](https://www.youtube.com/watch?v=U8GBXvdmHT4)
* [Git Workflows](http://blog.endpoint.com/2014/05/git-workflows-that-work.html)
* [OU Supercomputing Center for Education & Research (OSCER)](http://www.ou.edu/oscer.html)

