echo Enter local repository folder name:
read repoName
echo Enter git repository name:
read gitRepoName

mkdir C:/Users/Scott/Documents/Repo/$repoName
cd C:/Users/Scott/Documents/Repo/$repoName
git init
touch README
git add README
git commit -m 'Added README file'
git remote add origin git@github.com:ssmereka/$gitRepoName.git
git push -u origin master