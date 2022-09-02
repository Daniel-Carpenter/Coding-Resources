# Create webpage Apache Webserver

## Steps for Creating new Module

1. Create new module folder in directory `/var/www/html`. This is where the Apache webserver hosts your files.
    ```cmd
    cd /var/www/html

    sudo mkdir NewFolder
    cd NewFolder
    ```
2. Create `link` to the desired `html` webpage in NewFolder directory. Note `~/` indicates your home directory. Remove `~` to go straight to the path.
    ```cmd
    sudo ln -s ~/Link/To/The-File.html The-File.html
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

        Now create a password. Enter password when prompted.
        ```cmd
        sudo htpasswd -c .htpasswd new_user
        ```
    - Otherwise, if you wanted to link to another credential. You would do this if you were creating something like a user group login:
        ```cmd
        sudo ln -s ~/Link/To/.htaccess .htaccess
        sudo ln -s ~/Link/To/.htpasswd .htpasswd
        ```

6. Check to make sure the webpage works with passwords by pasting URL in browser
    ```
    http://adavena01.int.chickasaw.net/NewFolder/The-File.html
    ```

<br>

## What if the above steps do not work?
1. Restart the apache server. This usually fixes most issues
    ```cmd
    sudo systemctl restart httpd
    ```
2. Add the new folder to the apache configuration file. **Then restart the server from step 1 command.**  
    Edit the file
    ```cmd
    sudo nano /etc/httpd/conf/httpd.conf
    ```

    Copy and paste under the last configured webpage
    ```cmd
    # Allow access and security option to content 
    # within /var/www/html/NewFolder
    <Directory "/var/www/html/NewFolder">
        
        # Allow security with .htaccess file
        AllowOverride All
        
        # Allow open access (while on VPN):
        Require all granted

    </Directory>
    ```

<br>

## Areas to stay away from?
* Try avoiding changing the read write access using `chmod`. You should not need to do this. There was potentially an issue in the past with the server crashing when running this command.