/*
Read XML edition of Ap.Soph., and extract lemmata.  
Write 1 lemma per line to standard ouput.
*/
String usage = "groovy extractLemmat.groovy <XMLFILE>"

if (args.size() != 1) {
  System.err.println usage
  System.exit(-1)
}

groovy.xml.Namespace tei = new groovy.xml.Namespace("http://www.tei-c.org/ns/1.0")

File xmlFile = new File(args[0])
def root = new XmlParser().parse(xmlFile)

root[tei.text][tei.body][tei.div][tei.div][tei.ab].each { ab ->
  if (ab.'@type' == "lemma") {
    println ab.text()
  }
}
