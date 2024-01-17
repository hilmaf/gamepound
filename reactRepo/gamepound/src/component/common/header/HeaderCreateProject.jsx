import React from 'react';
import styled from 'styled-components';
import { useProjectCreateMemory } from '../../context/ProjectCreateContext';
import { useNavigate } from 'react-router-dom';

const StyledHeaderCreateProjectDiv = styled.div`

`;

const HeaderCreateProject = () => {

    const {projectCreateData, IsProjectInputChange, setIsProjectInputChange, dataFrom, headerFormVo, projectNo} = useProjectCreateMemory();
    const navigate = useNavigate();
    
    const handleSaveData = (e) => {
        const { name } = e.target;
        // basic 저장
        if(name === 'basic'){
            const formData = new FormData();

            // 프로젝트 제목 검증
            if(headerFormVo.title && headerFormVo.title.length > 50){
                alert('프로젝트 제목이 50글자가 넘습니다.');
                return;
            }
            // 대분류 카테고리 검증
            if(headerFormVo.mainCategoryNo && headerFormVo.mainCategoryNo === 0){
                alert('대분류 카테고리를 선택해주세요.');
                return;
            }
            // 소분류 카테고리 검증
            if(headerFormVo.subCategoryNo && headerFormVo.subCategoryNo === 0){
                alert('소분류 카테고리를 선택해주세요.');
                return;
            }
            
            formData.append('no', projectNo.no);
            formData.append('title', headerFormVo.title);
            formData.append('mainCategoryNo', headerFormVo.mainCategoryNo);
            formData.append('subCategoryNo', headerFormVo.subCategoryNo);
            formData.append('imageUrl', headerFormVo.imageUrl);
            
            fetch('http://localhost:8889/gamepound/project/save/basic', {
                method: 'post',
                body: formData,
            })
            .then(resp => resp.json())
            .then(data => {
                if(data.msg === 'good'){
                    alert('프로젝트 내용이 저장되었습니다.');
                    navigate(`/projectCreate/main/index/basic/${projectNo.no}`);
                }
            })
            ;
            setIsProjectInputChange(false);
        }
        
        // plan 저장
        if(name === 'plan'){

            // 금액검증
            if(headerFormVo.goalAmount < 500000){
                alert('목표금액을 500,000원 이상으로 설정해주세요.');
                return;
            }

            fetch('http://localhost:8889/gamepound/project/save/plan', {
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(headerFormVo),
            })
            .then(resp => resp.json())
            .then(data => {
                if(data.msg === 'good'){
                    alert('프로젝트 내용이 저장되었습니다.');
                    navigate(`/projectCreate/main/index/plan/${projectNo.no}`);
                } else {
                    throw new Error();
                }
            })
            .catch((e) => {
                alert('오류가 발생했습니다. 다시 시도해주세요.');
            })
            ;
            setIsProjectInputChange(false);
            
        }

        // dateplan 저장
        if(name === 'dateplan'){
            console.log('확인');
            const fieldsToCheck = [
                { field: headerFormVo.txtDescription, label: '프로젝트 소개' },
                { field: headerFormVo.txtBudget, label: '프로젝트 예산' },
                { field: headerFormVo.txtSchedule, label: '프로젝트 일정' },
                { field: headerFormVo.txtTeam, label: '프로젝트 팀 소개' },
                { field: headerFormVo.txtItem, label: '프로젝트 선물 소개' }
            ];
            // 프로젝트 내용 검증
            for (const fieldData of fieldsToCheck) {
                if (fieldData.field && fieldData.field.length > 2000) {
                    alert(`${fieldData.label}은(는) 2000글자 이내로 작성해 주시기 바랍니다.`);
                    return;
                }
            }

            fetch('http://localhost:8889/gamepound/project/save/dateplan', {
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(headerFormVo),
            })
            .then(resp => resp.json())
            .then(data => {
                if(data.msg === 'good'){
                    alert('프로젝트 내용이 저장되었습니다.');
                } else {
                    throw new Error();
                }
            })
            .catch(() => {
                alert('오류가 발생했습니다. 다시 시도해주세요.');
            })
            ;
            setIsProjectInputChange(false);
        }
    }

    return (
        <StyledHeaderCreateProjectDiv>
            { // createMain 버튼
                (
                    projectCreateData ?
                        IsProjectInputChange ?
                        (
                            <button className="createMainStateBtn" name={dataFrom ? dataFrom : ''} onClick={handleSaveData}>저장하기</button>
                        )
                        :
                        ( 
                            <button
                                className="createMainStateBtn"
                                disabled={!(projectCreateData.totalCompletionRate === 100)}
                            >
                            {
                                projectCreateData.totalCompletionRate === 100 ?
                                '승인요청'
                                :
                                `기획중 · ${projectCreateData.totalCompletionRate}% 완료`
                            }
                            </button>
                        )
                    :
                    ''
                )
            }
        </StyledHeaderCreateProjectDiv>
    );
};

export default HeaderCreateProject;