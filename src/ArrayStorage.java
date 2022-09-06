/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];


    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r; //TODO может поле size?
    }

    Resume get(String uuid) {
        //TODO может типо mergesort?

        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];      // вроде уникальные отсортированые ..
//               break;
            }
        }
        return null;                    // ..??

    }

    void delete(String uuid) {
        // если неск                        - вроде уникальные
        // если нету такого                 - ... ??
        // size                             - пока авто пересчет
        // если удалить из середины         - ok

        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
//                storage[i]=null ;                     // depricated

//                for (int j = i; j < size(); j++) {    // depricated
//                    storage[j] = storage[j + 1];
//                }
//                break;

//                if (size() - i >= 0) {
                System.arraycopy(storage, i + 1, storage, i, size() - i);
                break;             //чтоб удалил только один такой- даже если уникальные ) и можно свап
//                }


            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] res2 = new Resume[size()];
        System.arraycopy(storage, 0, res2, 0, size());
        return res2;
    }

    int size() {
        int cnt = 0;
        for (Resume rsm : storage) {
            if (rsm != null) cnt++;
            else break;         // ?  сокращает цикл вроде ..
        }
        return cnt;
    }


}
