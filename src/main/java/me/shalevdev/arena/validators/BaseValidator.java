package me.shalevdev.arena.validators;

import org.bukkit.command.CommandSender;

public abstract class BaseValidator{
    private BaseValidator nextValidator;
    private BaseValidator rootValidator;
    public BaseValidator(){
        this.nextValidator = null;
        this.rootValidator = null;
    }

    public BaseValidator setNext(BaseValidator nextValidator){
        this.nextValidator = nextValidator;
        this.nextValidator.rootValidator = getRootValidator();
        return this.nextValidator;
    }
    public BaseValidator getRootValidator(){
        return this.rootValidator == null ? this : this.rootValidator;
    }

    protected boolean passToNextValidator(CommandSender sender, String[] commandArgs){
        if (nextValidator == null){
            return true;
        }
        else{
            return nextValidator.validate(sender, commandArgs);
        }
    }

    public abstract boolean validate(CommandSender sender, String[] commandArgs);
}
