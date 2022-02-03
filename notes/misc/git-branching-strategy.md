# Git Worflow
We will be following Kyle's preferred git branching strategy of working/feature branches.

 - Never change main directly, main is the central authority of good code. That means that we only merge good tested and complete code and features into main. Then we can expect that pulling from main gives us good tested and complete code.
 - Create your own feature/working branches to work with. Branch these off main with `git branch new-branch-name` or `git checkout -b new-branch-name`
 - Only make changes to code and files in your own working branches. Never checkout a peer's branch and change that. If you want to you can branch off of any branch. When you create a new branch, it forks from the current branch. So, if you wanted to work on a perr's branch, check it out and branch it for yourself.
 - Commit CONSTANTLY, and be verbose in commit history messages. If you finish working in some class or method, commit. If you complete a feature, commit. You should be committing multiple times a day. Maybe even multiple times an hour. The more often you commit, the easier it is to revert to a particular state later. 
 - Push whenever you want to send the data to the central repository. Commits are more important than pushes. Push is just a copy operation.
 - When the code in your branch is good, tested, and complete then you will push it, and then create a pull request. Pull request is how we merge code into main.
 - Create a pull request, and double, **then tripple check** the arrow and what is going where! Remember the arrow goes right-to-left.
 - Now we correct any merge conflicts and complete the pull request. For larger groups at this point it may be good to have a workflow that involves getting reviewers to sign off on the changes before merging to main. Note: `git pull` and pull request are completely different things. `git pull` is a git command. A pull request is a GitHub workflow for merging branches. 
 - Now main has the most up-to-date code, and if you wanted to get that code in your own branch, just do a pull from main into your branch: `git pull origin main`. When we do a git pull it defaults to pulling from the default origin and current branch. If we wanted to pull from some other location, like main, we just specify.
