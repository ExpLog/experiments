# Notes

1. {{ ansible\_managed }} default is just "Ansible managed", so it won't interefere with tasks being idempotent.


## Vagrant on Windows

Easiest way to use Vagrant on Windows is to use the Hyper-V provider. However, in order to run vagrant up, you'll need a cmd with administrative privileges. Unfortunately, this is a limitation of Hyper-V.