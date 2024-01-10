import React, { createContext, useContext, useEffect, useState } from 'react';

const BackingMemory = createContext();

const useBackingMemory = () => {
    const obj = useContext(BackingMemory);
    return obj;
}

const BackingMemoryProvider = ({children}) => {
    
    const [dataVo, setDataVo] = useState({});

    // dataVo, setDataVo 객체 1개로 합치기
    const dataSet = {
        dataVo,
        setDataVo
    }

    // 프로젝트 정보, 후원 정보 fetch
    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {
            // 후원자 이메일 정보 채우기
            // 세션스토리지에서 로그인 멤버 값 가져와서 dataVo에 넣기

            data.memberEmail = sessionStorage.getItem("loginMemberVo");
            setDataVo(data);
        })
        ;
    }

    // 렌더링 1번만
    useEffect(()=>{
        loadBackingFormInfo();
    }, [])
    
    return (
        <BackingMemory.Provider value={dataSet}>
            {children}
        </BackingMemory.Provider>
    );
};

export {useBackingMemory, BackingMemoryProvider};