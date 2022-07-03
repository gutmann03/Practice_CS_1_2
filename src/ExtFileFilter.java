import javax.swing.filechooser.FileFilter;

class ExtFileFilter extends FileFilter
{
    private String ext;
    public ExtFileFilter(String ext)
    {
        this.ext = ext;
    }
    public boolean accept(java.io.File file)
    {
        if(file.isDirectory()) return true;
        return (file.getName().endsWith(ext));
    }
    public String getDescription()
    {
        return "*" + ext;
    }
}