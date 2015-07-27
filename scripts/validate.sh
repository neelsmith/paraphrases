
if [ "$#" -ne 1 ]; then
    echo "Usage: sh validate.sh URN"
    exit
fi


echo "Verifying from configuration in /vagrant/paraphrases/configs/vm-mom-config.gradle"


cd /vagrant/hmt-mom

echo "Cleaning previous HMT MOM results..."
gradle clean

echo Beginning verification for folio $1

gradle -Pfolio=$1 -Pconf=/vagrant/paraphrases/configs/vm-mom-config.gradle validate
