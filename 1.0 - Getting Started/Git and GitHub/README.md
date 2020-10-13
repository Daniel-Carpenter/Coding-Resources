*THE BELOW INFORMATION IS REPRODUCED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20).*

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



### Getting Started

#### Set name and email
To make commits with git, you first need to set your name and email address.
Open a terminal and run the following two commands:
```bash
git config --global user.name {name}
git config --global user.email {email address}
```
Make sure you replace `{name}` and `{email address}` with your actual name and email address.

#### Cloning
Navigate to the folder where you store your Eclipse projects.
To change folders in the terminal, use the command `cd {folder name}`.
To see a list of all the folders inside the current folder, use the command `ls`.

Once you're in the desired folder, retrieve your repository from the internet with the `clone` command:
``` bash
git clone https://github.com/{username}/{repository_name}
```
Instead of typing out the URL, you can copy it from GitHub by clicking the green "Code" button and then clicking the clipboard.
Paste the URL into the terminal by right-clicking the window and then selecting "Paste."

The clone command will create a new folder with the contents of your repo.
Feel free to change the name of this folder to something simpler like "Lab5".

#### Import into Eclipse
Once the repository has been cloned, import it into Eclipse with the "Open Projects from File System..." or "Import..." dialog, just like with past assignments.

#### Updating git index
To save your code changes, you must first add the source files to the git index (the index designates which files git is tracking).
This is done by running the `add` command in the root folder of your project:
```sh
git add src\IntegerList.java
```
You can add all changed files with the `-A` option:
```bash
git add -A
```

#### Committing code
After adding files to the git index, save the changes with the `commit` command.
Developers should always include a descriptive commit message with the `-m` option:
``` bash
git commit -m "Meaningful commit message here"
```

#### Updating remote
At this point, your local copy of the repository is updated, but your GitHub repo still has the old files.
To update your remote repository, use the `push` command. 
Note that push requires that you specify where it pushes to.
Thankfully, by cloning a repo from GitHub using `git clone`, git will automatically configure the local repository to push to the correct URL.
This destination is code-named "origin", and it can be used as the argument for push:
``` bash
git push origin
```
