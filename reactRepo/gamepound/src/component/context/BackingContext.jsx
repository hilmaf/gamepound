import React, { createContext, useContext, useEffect, useState } from 'react';

const BackingMemory = createContext();

const useBackingMemory = () => {
    const obj = useContext(BackingMemory);
    return obj;
}

const BackingMemoryProvider = ({children}) => {
    
    const [dataVo, setDataVo] = useState({});

    // 프로젝트 정보, 후원 정보 fetch
    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {

            const newData = {
                ...data
            }
            // 후원자 이메일 정보 채우기
            // 세션스토리지에서 로그인 멤버 값 가져와서 dataVo에 넣기

            newData.memberEmail = sessionStorage.getItem("loginMemberVo");
            setDataVo(newData);
            console.log(newData);
        })
        ;
    }

    // 렌더링 1번만
    useEffect(()=>{
        loadBackingFormInfo();
    }, [])
    
    return (
        <BackingMemory.Provider value={dataVo}>
            {children}
        </BackingMemory.Provider>
    );
};

export {useBackingMemory, BackingMemoryProvider};