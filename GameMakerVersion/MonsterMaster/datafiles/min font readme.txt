Min Font is packaged as a GameMaker Marketplace Asset.  The Marketplace Asset is simply a delivery tool which acts as a container for a couple of Included Files, which are TrueType Font files.

Adding the min font package to your project does not install the fonts to your system; it merely adds them as Included Files in your GM:S project.

To actually install the fonts, you'll need to:

1. Browse to the file location fonts, by right-clicking on the included file in the resource tree, then selecting "Open in Explorer".  
2. Right click each .ttf file, then select "Install".  The file will install itself to the system, copying itself to %windir%\Fonts
3. Now that the fonts are installed to the system, you can create Font resources in your GM:S projects.