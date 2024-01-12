import React, { createContext, useContext, useEffect, useState } from 'react';
import { useUserMemory } from './UserContext';

const BackingMemory = createContext();

const useBackingMemory = () => {
    const obj = useContext(BackingMemory);
    return obj;
}

const BackingMemoryProvider = ({children}) => {

    // useContext - loginMember
    const {loginMemberVo} = useUserMemory();
    console.log("provider > loginMemberVo " , loginMemberVo);
    
    const [dataVo, setDataVo] = useState({
        "memberNo": '111111',
        "memberEmail": '222',
    });
    
    // 프로젝트 정보, 후원 정보 fetch
    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {
            console.log("!!!!!111" , dataVo);
            console.log("!!!!!222" , data);
            setDataVo({
                ...dataVo,
                ...data,
            });
        })
        ;
    }
    
    // 렌더링 1번만
    useEffect(()=>{
        loadBackingFormInfo();
        if(loginMemberVo) {
            console.log("Backing context > useEffect " , loginMemberVo);
        } else {
            alert("로그인해야 들어갈 수 있는 페이지");
        }
    }, [setDataVo])

    // dataVo, setDataVo 객체 1개로 합치기
    const dataSet = {
        dataVo,
        setDataVo
    }
    
    return (
        <BackingMemory.Provider value={dataSet}>
            {children}
        </BackingMemory.Provider>
    );
};

export {useBackingMemory, BackingMemoryProvider};