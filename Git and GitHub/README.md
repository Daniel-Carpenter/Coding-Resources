*THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20).*

## Git and GitHub Tutorial 

* Git and GitHub tutorial tutorial on using [Git and GitHub.com](https://github.com/tyleransom/DScourseS20/blob/master/Productivity/git_tutorial.pdf) (reproduced with permission from [Rick Evans](https://github.com/rickecon) at U Chicago). 
* [Git](https://xkcd.com/1597/)
* [Git Commit](https://xkcd.com/1296/)


### Main Git Commands 

| Functionality                                               | Git Command                                                      |
|-------------------------------------------------------------|------------------------------------------------------------------|
| Pull to Fork                                                | `git pull`                                                       |
| Add and Commit all Changes                                  | `git add -A`                                                     |
| Push committed changes updstream                            | `git push origin master`                                         |


### Other Git Commands

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
| Clone a remote repository                                   | `git clone <url to remote repo>`                                   |
