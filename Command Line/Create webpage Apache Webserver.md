# Create webpage Apache Webserver

## Steps for Creating new Module

1. Create new module folder in directory `/var/www/html`. This is where the Apache webserver hosts your files.
    ```cmd
    cd /var/www/html

    sudo mkdir NewFolder
    cd NewFolder
    ```
2. Create `link` to the desired `html` webpage and name it `index.html` in new folder. Note `~/` indicates your home directory. Remove `~` to go straight to the path.
    ```cmd
    sudo ln -s ~/Link/To/The-File.html index.html
    ```

3. Allow read only access to the folder
    ```cmd
    chmod 0755 /var/www/html/NewFolder/
    ```
4. Add the new folder to the apache configuration file
    ```cmd
    ```

5. Add login security by linking the .htaccess and .htpasswd in the category directory, or make a new credential
    - Creating credential:
        ```cmd
        sudo nano .htaccess
        ```

        Copy and paste following with updated directory:
        ```cmd
        <LIMIT GET POST>
        Require valid-user
        </LIMIT>

        AuthType     Basic
        AuthName     "Security for this folder" 
        AuthUserFile "/var/www/html/NewFolder/.htpasswd"
        ```

        Now create a password
        ```cmd
        sudo htpasswd -c .htpasswd new_user
        ```
    - Linking to other credential:
        ```cmd
        sudo ln -s ~/Link/To/.htaccess .htaccess
        sudo ln -s ~/Link/To/.htpasswd .htpasswd
        ```
6. Restart the server etc.
    ```cmd
    ```
7. Check to make sure the webpage works by pasting URL in browser
    ```cmd
    ```
